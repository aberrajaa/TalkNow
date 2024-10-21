package fr.mightycode.cpoo.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.mightycode.cpoo.server.dto.UserInscriptionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_info")
public class UserInfo {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "login", nullable = false, unique = true)
  private String login;
  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "firstname")
  private String firstName;
  @Column(name = "secondname")
  private String secondName;

  @Column(name = "adress")
  private String adress;

  @Column(name = "birthday")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date birthdayDate;

  @Column(name = "avatar")
  private String avatar;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_info_id")
  private List<Contact> contacts;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_conversation_id")
  private List<MyConversation> conversations;

  public UserInfo(String log, String pass, String first, String second, String add, Date birthday) {
    this.login = log;
    this.password = pass;
    this.firstName = first;
    this.secondName = second;
    this.adress = add;
    this.birthdayDate = birthday;
    this.avatar = "assets/avatar1.png";
    this.contacts = new ArrayList<Contact>();
    this.conversations = new ArrayList<MyConversation>();
  }

  public UserInfo(UserInscriptionDTO user) {
    this.login = user.getLogin();
    this.password = user.getPassword();
    this.firstName = user.getFirstname();
    this.secondName = user.getSecondname();
    this.adress = user.getAddress();
    this.birthdayDate = user.getDate();
    this.avatar = "assets/avatar1.png";
    this.contacts = new ArrayList<Contact>();
    this.conversations = new ArrayList<MyConversation>();
  }

}
