import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  //Défini les appels aux End-Points pour la page home
  private apiUrl = '/serverapi/profile';

  constructor(private http: HttpClient) {}

  //Permet de récupérer les informations de l'utilisateur connecté
  getUserHomeData(): Observable<UserHomeInfoDTO> {
    return this.http.get<UserHomeInfoDTO>(`${this.apiUrl}/accueil`, {
      withCredentials: true,
    });
  }

  //Permet de récupérer les conversations de l'utilisateur
  getUserConversation(): Observable<ConversationDTO[]> {
    return this.http.get<ConversationDTO[]>(`${this.apiUrl}/conversations`, {
      withCredentials: true,
    });
  }

  //Permet d'envoyer un message
  envoyerMessage(newMessageDTO: NewMessageDTO, conversationId: number) {
    const payload = {
      to: newMessageDTO.to,
      type: newMessageDTO.type,
      body: newMessageDTO.body,
    };
    return this.http.post<Message[]>(
      `serverapi/message/${conversationId}`,
      payload,
      { withCredentials: true }
    );
  }

  //Permet de récuperer les messages reçus
  recupererMessage() {
    return this.http.get<Message>(`serverapi/message`, {
      withCredentials: true,
    });
  }
}

export interface UserHomeInfoDTO {
  firstname: string;
  avatar: string;
}

export interface NewMessageDTO {
  to: string;
  type: string;
  body: string;
}

export interface ConversationDTO {
  id: number;
  contactPseudo: string;
  contactAvatar: string;
  lastMessage: string;
  lastMessageDate: Date;
  myMessages: Message[];
}

export interface Message {
  id: string;
  timestamp: number;
  from: string;
  to: string;
  type: string;
  body: string;
}
