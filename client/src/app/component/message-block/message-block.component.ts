import { Component, Input } from '@angular/core';
import { HomeService } from 'src/app/service/home.service';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-message-block',
  templateUrl: './message-block.component.html',
  styleUrls: ['./message-block.component.css'],
})
export class MessageBlockComponent {
  constructor(private userService: UserServiceService) {}

  usertest: any;

  @Input() message: string = '';
  @Input() from: string = '';

  ngOnInit() {
    this.userService.getUserData().subscribe((userData) => {
      this.usertest = userData;
    });
  }

  // Vérifie si le message provient de l'utilisateur connecté
  isFromEqualToUserLogged(from: string, userlogged: string): boolean {
    const fromSplited = from.split('@')[0];
    return fromSplited === userlogged;
  }
}
