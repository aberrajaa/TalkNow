package fr.mightycode.cpoo.server.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "contact")
public class Contact {
  @Id
  @GeneratedValue
  private long id;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "email")
  private String email;

  @Column(name = "pseudo")
  private String pseudo;

  @Column(name = "avatar")
  private String avatar;

  @Column(name = "domain")
  private String domain;

  @ManyToOne
  @JoinColumn(name = "user_info_id")
  private UserInfo userInfo;

  public Contact(String firstname, String lastname, String email, String pseudo, String domain, UserInfo userInfo) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.pseudo = pseudo;
    this.avatar = "assets/avatar1.png";
    this.domain = domain;
    this.userInfo = userInfo;
  }
}
