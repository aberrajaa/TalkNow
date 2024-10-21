package fr.mightycode.cpoo.server.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class UserInscriptionDTO {
  private String login;
  private String password;
  private String firstname;
  private String secondname;
  private String address;
  private Date date;


}
