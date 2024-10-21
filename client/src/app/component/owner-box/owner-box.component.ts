import { Component } from '@angular/core';
import { HomeService } from 'src/app/service/home.service';

@Component({
  selector: 'app-owner-box',
  templateUrl: './owner-box.component.html',
  styleUrls: ['./owner-box.component.css'],
})
export class OwnerBoxComponent {
  owner: UserHomeInfoDTO | undefined;

  constructor(private homeService: HomeService) {}

  //Récuperations des informations de l'utilisateur actuellement connecté
  ngOnInit() {
    this.homeService.getUserHomeData().subscribe((owner) => {
      this.owner = owner;
    });
  }
}

export interface UserHomeInfoDTO {
  firstname: string;
  avatar: string;
}
