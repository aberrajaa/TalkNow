import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { UserServiceService } from 'src/app/service/user-service.service';
import { first } from 'rxjs';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  user = {
    login: '',
    password: '',
    firstname: '',
    secondname: '',
    address: '',
    date: new Date(),
  };
  errormessage = '';
  passwordConfirmation = '';
  isPhonePortrait = false;

  constructor(
    private router: Router,
    private responsive: BreakpointObserver,
    private userService: UserServiceService
  ) {}

  redirectToConnexion() {
    this.router.navigate(['/']);
  }

  //Permet d'imposer le login pour gérer plus facilement les données dans le back-end
  updateLogin() {
    this.user.login = `${this.user.firstname}.${this.user.secondname}`;
  }

  //Permet d'imposer l'email pour gérer plus facilement les données dans le back-end
  updateEmail() {
    this.user.address = `${this.user.firstname}.${this.user.secondname}@talknow`;
  }

  //Fonction qui permet de se s'inscrire
  signup() {
    if (this.user.password !== this.passwordConfirmation) {
      this.errormessage = 'Les deux mots de passe sont différents !';
      return;
    }
    this.userService.signup(this.user).subscribe(
      () => {
        this.errormessage = '';
        this.router.navigate(['/']); // Rediriger en cas de succès
      },
      (error) => {
        if (error.error.message === 'Already exist') {
          this.errormessage = 'Cette utilisateur existe deja !';
        }
        if (error.error.message === 'mot de passe faux') {
          this.errormessage =
            'Le mot de passe doit contenir au moins 4 caractères !';
        }
        if (error.error.message === 'nom faux') {
          this.errormessage =
            "Le nom et prénom doivent être composés d'au moins un caractère et seulement des lettres !";
        }
      }
    );
  }

  ngOnInit() {
    this.responsive
      .observe([Breakpoints.HandsetPortrait, Breakpoints.TabletPortrait])
      .subscribe((result) => {
        this.isPhonePortrait = result.matches;
      });
  }
}
