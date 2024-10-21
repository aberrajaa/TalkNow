import { Component } from '@angular/core';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-settings-page',
  templateUrl: './settings-page.component.html',
  styleUrls: ['./settings-page.component.css'],
})
export class SettingsPageComponent {
  editFirstName: boolean = false;
  editLastName: boolean = false;
  editUsername: boolean = false;
  editPassword: boolean = false;
  avatarList: string[] = [
    'assets/avatar1.png',
    'assets/avatar2.png',
    'assets/avatar3.png',
    'assets/avatar4.png',
    'assets/avatar5.png',
    'assets/avatar6.png',
    'assets/avatar7.png',
    'assets/avatar8.png',
    'assets/avatar9.png',
    'assets/avatar10.png',
    'assets/avatar11.png',
    'assets/avatar12.png',
    'assets/avatar13.png',
    'assets/avatar14.png',
    'assets/avatar15.png',
    'assets/avatar16.png',
    'assets/avatar17.png',
    'assets/avatar18.png',
  ];
  motdepasse = '';
  editAvatar: boolean = false;
  showPassword: boolean = false;
  usertest: any;

  constructor(private userService: UserServiceService) {}
  // Fonction pour basculer la visibilité du mot de passe
  togglePasswordVisibility() {
    this.showPassword = !this.showPassword;
  }

  // Fonction pour mettre à jour l'avatar
  updateAvatar(newAvatar: string) {
    this.usertest.avatar = newAvatar;
    this.editAvatar = false;
  }

  // Fonction pour mettre à jour le nom d'utilisateur
  updateLogin(newLogin: string) {
    this.userService
      .updateProfileSetting('login', newLogin)
      .subscribe((response) => {
        console.log(response);
      });
  }

  // Fonction pour mettre à jour le mot de passe
  updatePassword(newPassword: string) {
    this.userService
      .updateProfileSetting('password', newPassword)
      .subscribe((response) => {
        console.log(response);
      });
  }

  // Fonction pour mettre à jour le prénom
  updateFirstname(newFirstname: string) {
    this.userService
      .updateProfileSetting('firstname', newFirstname)
      .subscribe((response) => {
        console.log(response);
      });
  }

  // Fonction pour mettre à jour le nom de famille
  updateLastname(newLastname: string) {
    this.userService
      .updateProfileSetting('lastname', newLastname)
      .subscribe((response) => {
        console.log(response);
      });
  }

  // Fonction pour mettre à jour l'avatar avec une requête PUT
  updatePutAvatar(newAvatar: string) {
    this.userService
      .updateProfileSetting('avatar', newAvatar)
      .subscribe((response) => {
        console.log(response);
      });
  }

  // Fonction appelée lors de l'initialisation du composant
  ngOnInit() {
    this.userService.getUserData().subscribe((userData: User) => {
      this.usertest = userData;
      if (this.usertest.birthdayDate) {
        const date = new Date(this.usertest.birthdayDate);
        this.usertest.birthdayDate = date.toLocaleDateString();
      }
    });
  }
}

// Interface pour définir la structure des données de l'utilisateur
export interface User {
  login: string;
  password: string;
  firstName: string;
  secondName: string;
  adress: string;
  birthdayDate: Date;
  avatar: String;
}
