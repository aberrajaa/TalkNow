package fr.mightycode.cpoo.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "messages")
public class MyMessage {
  @Id
  private UUID id;
  @ManyToOne
  @JoinColumn(name = "conversation_id")
  private MyConversation conversation;

  @Column(name = "messageDate")
  private LocalDateTime messageDate;

  @Column(name = "body")
  private String body;

}
