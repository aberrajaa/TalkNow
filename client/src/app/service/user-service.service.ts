import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root',
})
export class UserServiceService {
  //Défini les appels aux End-Points pour le signin et signup
  private apiUrl = 'serverapi';

  constructor(private http: HttpClient, private cookieService: CookieService) {}

  //Permet d'appeler la route pour s'inscrire
  signup(user: User) {
    return this.http.post(`${this.apiUrl}/user/signup`, user, {
      withCredentials: true,
    });
  }

  //Permet d'appeler la route pour se connecter
  signin(user: UserDTO) {
    localStorage.setItem('isLoggedIn', 'true');
    return this.http.post(`${this.apiUrl}/user/signin`, user, {
      withCredentials: true,
    });
  }

  //Permet de récupérer à partir du back-end les informations de l'utilisateur connecté
  getUserData(): Observable<Usertest> {
    return this.http.get<Usertest>(`${this.apiUrl}/profile/settings`, {
      withCredentials: true,
    });
  }

  //Permet d'appeler la route pour se déconnecter
  logout() {
    const body = {};
    localStorage.setItem('isLoggedIn', 'false');
    return this.http.post(`${this.apiUrl}/user/signout`, body, {
      withCredentials: true,
    });
  }

  //Permet d'appeler la route pour mettre à jour une information de l'utilisateur connecté
  updateProfileSetting(type: string, value: string): Observable<any> {
    const updateRequest = { type, value };
    return this.http.put(`${this.apiUrl}/profile/settings`, updateRequest, {
      withCredentials: true,
    });
  }

  //Récupère un booléen pour savoir si l'utilisateur est connecté ou non
  isLoggedIn(): boolean {
    const loggedIn = localStorage.getItem('isLoggedIn');
    return loggedIn === 'true';
  }
}
export interface Usertest {
  login: string;
  password: string;
  firstName: string;
  secondName: string;
  adress: string;
  birthdayDate: Date;
  avatar: String;
}

export interface User {
  login: string;
  password: string;
  firstname: string;
  secondname: string;
  address: string;
  date: Date;
}
export interface UserDTO {
  login: string;
  password: string;
}
