import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent {
  user = {
    login: '',
    password: '',
  };
  errormessage = '';
  constructor(
    private router: Router,
    private userService: UserServiceService
  ) {}
  redirectToInscription() {
    this.router.navigate(['/home']);
  }

  //Fonction qui permet à l'utilisateur de se connecter
  login() {
    this.userService.signin(this.user).subscribe(
      () => {
        this.errormessage = '';
        this.router.navigate(['/home']);
      },
      (error) => {
        if (error.error.message === 'Bad credentials') {
          this.errormessage = "Nom d'utilisateur ou mot de passe incorrect !";
        }
        if (error.error.message === 'User not registered') {
          this.errormessage = 'Utilisateur non enregistré !';
        }
        if (error.error.message === 'Already signed in') {
          this.router.navigate(['/home']);
        }
        if (error.error.message === 'Autre utilisateur actuellement connecte') {
          this.errormessage =
            'Un autre utilisateur est actuellement connecté, déconnectez-le avant !';
        }
      }
    );
  }
}
