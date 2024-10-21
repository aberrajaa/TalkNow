package fr.mightycode.cpoo.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserHomeInfoDTO {
  private String firstname;
  private String avatar;

  public UserHomeInfoDTO(String firstname, String avatar) {
    this.firstname = firstname;
    this.avatar = avatar;
  }
}
