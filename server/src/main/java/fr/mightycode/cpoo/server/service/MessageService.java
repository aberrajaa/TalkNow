package fr.mightycode.cpoo.server.service;

import fr.mightycode.cpoo.server.model.Message;
import fr.mightycode.cpoo.server.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class MessageService {

  private final MessageRepository messageRepository;
  // All incoming messages from the router are queued into per recipient queues
  private final Map<String, BlockingQueue<Message>> messageQueues = new HashMap<>();
  @Value("${cpoo.server.domain}")
  private String serverDomain;

  /**
   * Get the message queue of the recipient (create it if it does not exist).
   *
   * @param to The recipient address
   * @return the message queue of the recipient
   */
  private BlockingQueue<Message> getQueue(String to) {
    BlockingQueue<Message> messageQueue = messageQueues.get(to);
    if (messageQueue == null) {
      messageQueue = new ArrayBlockingQueue<>(10);
      messageQueues.put(to, messageQueue);
    }
    return messageQueue;
  }

  /**
   * Store a message in the database.
   *
   * @param message The message to store
   * @return the stored message
   */
  public Message storeMessage(Message message) {
    return messageRepository.save(message);
  }

  /**
   * Queue a message into a the message queue of a recipient.
   *
   * @param message The message to queue
   */
  public void queueMessage(Message message) {
    getQueue(message.getTo()).add(message);
  }

  /**
   * Get all messages send to or by a given user.
   *
   * @param login The user login
   * @return the list of messages sent to or by the user
   */
  public List<Message> getMessages(String login) {
    String userAddress = login + "@" + serverDomain;
    return messageRepository.findByFromOrToIgnoreCaseOrderByTimestampDesc(userAddress, userAddress);
  }

  /**
   * Get the next message sent to a given user.
   * This call blocks until an incoming message is received for the user or until a timeout expires.
   *
   * @param to The user address
   * @return the message
   */
  public Message getNextMessage(String to) throws InterruptedException {
    return getQueue(to).poll(5, TimeUnit.SECONDS);
  }
}

