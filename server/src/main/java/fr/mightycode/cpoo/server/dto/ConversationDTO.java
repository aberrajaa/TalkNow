package fr.mightycode.cpoo.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ConversationDTO {
  private long id;
  private String contactPseudo;
  private String contactAvatar;
  private String lastMessage;
  private OffsetDateTime lastMessageDate;
  private List<MessageDTO> myMessages;

  public ConversationDTO(long id, String contactPseudo, String contactAvatar, String lastMessage, OffsetDateTime lastMessageDate, List<MessageDTO> myMessages) {
    this.id = id;
    this.contactPseudo = contactPseudo;
    this.contactAvatar = contactAvatar;
    this.lastMessage = lastMessage;
    this.lastMessageDate = lastMessageDate;
    this.myMessages = myMessages;
  }

}
