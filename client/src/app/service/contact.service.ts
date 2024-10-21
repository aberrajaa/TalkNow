import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ContactService {
  //Défini les appels aux End-Points pour la page de contact
  private apiUrl = 'serverapi/profile';

  constructor(private http: HttpClient) {}

  //Permet de récupérer les contacts de l'utilisateur
  getContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${this.apiUrl}/contact`, {
      withCredentials: true,
    });
  }

  //Permet d'ajouter un contact à la liste de contact
  addContacts(emailData: AjoutContactDTO): Observable<Contact[]> {
    return this.http
      .post(`${this.apiUrl}/contact`, emailData, { withCredentials: true })
      .pipe(map((response: any) => response as Contact[]));
  }

  //Permet de modifier les informations sur un contact
  updateContact(
    contactId: number,
    type: string,
    value: string
  ): Observable<Contact[]> {
    const updateRequest = { type, value };
    return this.http.put<Contact[]>(
      `${this.apiUrl}/contact/${contactId}`,
      updateRequest,
      { withCredentials: true }
    );
  }

  //Permet de supprimer un contact
  deleteContact(contactId: number): Observable<Contact[]> {
    return this.http.delete<Contact[]>(`${this.apiUrl}/contact/${contactId}`, {
      withCredentials: true,
    });
  }

  //Permet de créer une conversation
  createConversation(contactId: number): Observable<any> {
    const options = {
      withCredentials: true,
    };
    return this.http.post(`${this.apiUrl}/contact/${contactId}`, null, options);
  }

  createNewConversation(contactId: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/contact/${contactId}`, {
      withCredentials: true,
    });
  }
}

export interface AjoutContactDTO {
  email: string;
}

export interface Contact {
  firstname: string;
  lastname: string;
  email: string;
  pseudo: string;
  avatar: string;
  id: number;
}
