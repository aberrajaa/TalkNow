package fr.mightycode.cpoo.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class UserInfoDTO {
  private String login;
  private String password;
  private String firstName;
  private String secondName;
  private String adress;
  private Date birthdayDate;
  private String avatar;

  public UserInfoDTO(String login, String password, String firstname, String secondname, String adress, Date birthdayDate, String avatar) {
    this.login = login;
    this.password = password;
    this.firstName = firstname;
    this.secondName = secondname;
    this.adress = adress;
    this.birthdayDate = birthdayDate;
    this.avatar = avatar;
  }

}
