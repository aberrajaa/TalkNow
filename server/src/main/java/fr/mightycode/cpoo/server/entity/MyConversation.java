package fr.mightycode.cpoo.server.entity;

import fr.mightycode.cpoo.server.model.Message;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "myconversations")
public class MyConversation {
  @Id
  @Column(name = "id", unique = true)
  @GeneratedValue
  private long id;
  @Column(name = "contactLogin", nullable = false)
  private String contactPseudo;
  @Column(name = "avatar", nullable = false)
  private String contactAvatar;
  @Column(name = "lastMessage", nullable = false)
  private String lastMessage;
  @Column(name = "lastMessageDate")
  private OffsetDateTime lastMessageDate;
  @ManyToOne
  @JoinColumn(name = "user_info")
  private UserInfo userInfo;


  @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL)
  private List<Message> myMessages;


  public MyConversation(String contactPseudo, String avatar, UserInfo userInfo) {
    this.contactPseudo = contactPseudo;
    this.contactAvatar = avatar;
    this.lastMessage = "";
    this.lastMessageDate = null;
    this.userInfo = userInfo;
    this.myMessages = new ArrayList<>();
  }

}
