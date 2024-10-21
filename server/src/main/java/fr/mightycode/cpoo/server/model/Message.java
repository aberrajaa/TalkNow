package fr.mightycode.cpoo.server.model;

import fr.mightycode.cpoo.server.entity.MyConversation;
import fr.mightycode.cpoo.server.service.RouterService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
@Entity
@Table(name = "messages")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;        // unique id of the message

  @Column(name = "timestamp", nullable = false)
  private long timestamp; // timestamp of the message

  @Column(name = "`from`", nullable = false)
  private String from;    // sender address

  @Column(name = "`to`", nullable = false)
  private String to;      // recipient address

  @Column(name = "type", nullable = false)
  private String type;    // MIME type of the body

  @Column(name = "body", nullable = false)
  private String body;    // body (BASE64 encoded for binary types)


  //@JoinColumn(name = "conversation_id")
  @ManyToOne
  @JoinColumn(name = "myconversations_id")
  private MyConversation conversation;

  public Message() {
  }

  public Message(RouterService.Message routerMessage) {
    this.id = routerMessage.id();
    this.timestamp = routerMessage.timestamp();
    this.from = routerMessage.from();
    this.to = routerMessage.to();
    this.type = routerMessage.type();
    this.body = routerMessage.body();
  }

  public Message(RouterService.Message routerMessage, MyConversation conversation) {
    this.id = routerMessage.id();
    this.timestamp = routerMessage.timestamp();
    this.from = routerMessage.from();
    this.to = routerMessage.to();
    this.type = routerMessage.type();
    this.body = routerMessage.body();
  }
}

