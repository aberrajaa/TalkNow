import { Component, ElementRef, Renderer2, ViewChild } from '@angular/core';
import { SelectedConversationService } from 'src/app/service/selected-conversation.service';
import { HomeService } from 'src/app/service/home.service';
import { interval } from 'rxjs';
@Component({
  selector: 'app-message-container',
  templateUrl: './message-container.component.html',
  styleUrls: ['./message-container.component.css'],
})
export class MessageContainerComponent {
  messages: Message[] = [];
  newMessage: string = '';
  selectedConversation: ConversationDTO | null = null;
  @ViewChild('messageContainer') private messageContainer?: ElementRef;

  constructor(
    private selectedConversationService: SelectedConversationService,
    private homeService: HomeService
  ) {
    this.scrollToBottom();
    this.selectedConversationService.selectedConversation$.subscribe(
      (conversation) => {
        this.selectedConversation = conversation;
        this.messages = [];
        if (
          conversation &&
          conversation.myMessages &&
          conversation.myMessages.length > 0
        ) {
          this.messages = conversation.myMessages;
        }
      }
    );
  }

  ngOnInit() {
    this.scrollToBottom();
  }

  // Fait défiler vers le bas de la fenêtre de messages
  scrollToBottom(): void {
    try {
      if (this.messageContainer) {
        this.messageContainer.nativeElement.scrollTop =
          this.messageContainer.nativeElement.scrollHeight;
      }
    } catch (err) {}
  }

  // Envoie un nouveau message
  sendMessage(newMessage: string) {
    if (newMessage.length !== 0) {
      if (this.selectedConversation) {
        const messageToSend = new NewMessageDTO(
          this.selectedConversation.contactPseudo,
          'string',
          newMessage
        );
        this.homeService
          .envoyerMessage(messageToSend, this.selectedConversation.id)
          .subscribe((newmessages) => {
            this.messages = newmessages;
          });
        this.newMessage = '';
      }
    }
  }

  // Sélectionne une conversation
  onConversationSelected(conversation: ConversationDTO) {
    this.selectedConversation = conversation;
    if (conversation.myMessages && conversation.myMessages.length > 0) {
      this.messages = conversation.myMessages;
    }
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

// Interface pour définir la structure d'un message
export interface Message {
  id: string;
  timestamp: number;
  from: string;
  to: string;
  type: string;
  body: string;
}

// Classe pour définir la structure d'un nouveau message
export class NewMessageDTO {
  constructor(public to: string, public type: string, public body: string) {}
}
