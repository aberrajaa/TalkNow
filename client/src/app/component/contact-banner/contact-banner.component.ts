import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-contact-banner',
  templateUrl: './contact-banner.component.html',
  styleUrls: ['./contact-banner.component.css'],
})
export class ContactBannerComponent {
  @Input() selectedConversation: ConversationDTO | null = null;
}

export interface ConversationDTO {
  id: number;
  contactPseudo: string;
  contactAvatar: string;
  lastMessage: string;
  lastMessageDate: Date;
  myMessages: Message[];
}

export interface Message {}
