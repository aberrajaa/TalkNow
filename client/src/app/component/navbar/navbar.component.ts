import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(
    private router: Router,
    private userService: UserServiceService
  ) {}

  //Redirections lors du click sur les boutons de la navbar
  redirectToContact() {
    this.router.navigate(['/contact']);
  }
  redirectToHome() {
    this.router.navigate(['/home']);
  }
  redirectToSettings() {
    this.router.navigate(['/parametres']);
  }
  redirectToAccueil() {
    this.userService.logout().subscribe(() => {
      this.router.navigate(['']);
    });
  }
}
