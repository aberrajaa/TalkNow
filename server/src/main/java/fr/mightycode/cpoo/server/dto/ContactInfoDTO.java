package fr.mightycode.cpoo.server.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfoDTO {
  private String firstname;
  private String lastname;
  private String email;
  private String pseudo;
  private String avatar;

  private long id;

  public ContactInfoDTO(String firstname, String lastname, String email, String pseudo, String avatar, long id) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.pseudo = pseudo;
    this.avatar = avatar;
    this.id = id;
  }
}
