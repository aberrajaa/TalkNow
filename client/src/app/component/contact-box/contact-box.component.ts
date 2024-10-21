import {
  ChangeDetectorRef,
  Component,
  EventEmitter,
  Output,
} from '@angular/core';
import { HomeService } from 'src/app/service/home.service';
import { SelectedConversationService } from 'src/app/service/selected-conversation.service';
import { interval, map, repeat, retry, share, takeUntil } from 'rxjs';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-contact-box',
  templateUrl: './contact-box.component.html',
  styleUrls: ['./contact-box.component.css'],
})
export class ContactBoxComponent {
  searchValue: string = '';
  selectedConversation: ConversationDTO | null = null;
  conversationName = '';
  unreadConversations: Set<string> = new Set();
  @Output() conversationSelected = new EventEmitter<ConversationDTO>();
  conversations: ConversationDTO[] = [];
  constructor(
    private homeService: HomeService,
    private selectedConversationService: SelectedConversationService,
    private userService: UserServiceService
  ) {}

  ngOnInit() {
    this.fetchConversationsOninitialisation();
    this.homeService
      .recupererMessage()
      .pipe(
        map((message) => {
          if (message) {
            this.fetchConversations();
            const conversationToUpdate = this.conversations.find(
              (conversation) =>
                conversation.contactPseudo === this.fromSplited(message.from)
            );
            if (conversationToUpdate) {
              conversationToUpdate.myMessages.push(message);
              if (
                this.selectedConversation &&
                this.selectedConversation.contactPseudo ===
                  conversationToUpdate.contactPseudo
              ) {
                this.selectedConversationService.setSelectedConversation(
                  conversationToUpdate
                );
              } else {
                this.unreadConversations.add(
                  conversationToUpdate.contactPseudo
                );
              }
            }
          }
          return message;
        }),
        repeat(),
        share()
      )
      .subscribe(() => {
        this.fetchConversations();
      });
  }

  // Cette fonction calcule la date relative du dernier message reçu
  getRelativeDate(lastMessageDate: Date): string {
    const currentDate = new Date();
    const messageDate = new Date(lastMessageDate);

    const timeDifference = currentDate.getTime() - messageDate.getTime();
    const secondsDifference = Math.floor(timeDifference / 1000);
    const minutesDifference = Math.floor(secondsDifference / 60);
    const hoursDifference = Math.floor(minutesDifference / 60);
    const daysDifference = Math.floor(hoursDifference / 24);

    if (daysDifference === 0) {
      return "Aujourd'hui";
    } else if (daysDifference === 1) {
      return 'Hier';
    } else {
      return `Il y a ${daysDifference} jours`;
    }
  }

  // Cette fonction extrait le nom d'utilisateur du champ "from" d'un message
  fromSplited(from: string): string {
    const fromSplited = from.split('@')[0];
    return fromSplited;
  }

  // Cette fonction convertit un timestamp en heure et minute
  timestampToTime(timestamp: Date): string {
    const hours = timestamp.getHours();
    const minutes = timestamp.getMinutes();
    return `${hours}:${minutes}`;
  }

  // Cette fonction récupère la liste des conversations de l'utilisateur et la trie par date du dernier message
  fetchConversations() {
    this.homeService.getUserConversation().subscribe((conversations) => {
      this.conversations = conversations;
      this.conversations.sort((a, b) => {
        const dateA = new Date(a.lastMessageDate).getTime();
        const dateB = new Date(b.lastMessageDate).getTime();
        return dateB - dateA;
      });
    });
  }

  // Cette fonction récupère les conversations au chargement initial et sélectionne la première conversation si elle existe
  fetchConversationsOninitialisation() {
    this.homeService.getUserConversation().subscribe((conversations) => {
      this.conversations = conversations;
      this.conversations.sort((a, b) => {
        const dateA = new Date(a.lastMessageDate).getTime();
        const dateB = new Date(b.lastMessageDate).getTime();
        return dateB - dateA;
      });
      if (this.conversations.length > 0) {
        this.selectedConversationService.setSelectedConversation(
          this.conversations[0]
        );
      }
    });
  }

  // Cette fonction sélectionne une conversation et marque les messages non lus comme lus
  selectConversation(conversation: ConversationDTO) {
    this.selectedConversationService.setSelectedConversation(conversation);
    this.selectedConversation = conversation;
    this.conversationSelected.emit(conversation);
    this.unreadConversations.delete(conversation.contactPseudo);
  }

  // Cette fonction filtre les conversations en fonction du texte de recherche
  filterConversations(): ConversationDTO[] {
    return this.conversations?.filter((conversation) =>
      conversation.contactPseudo
        .toLowerCase()
        .includes(this.searchValue.toLowerCase())
    );
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
