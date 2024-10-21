import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SelectedConversationService {
  private selectedConversationSubject =
    new BehaviorSubject<ConversationDTO | null>(null);
  selectedConversation$ = this.selectedConversationSubject.asObservable();

  setSelectedConversation(conversation: ConversationDTO | null) {
    this.selectedConversationSubject.next(conversation);
  }
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
