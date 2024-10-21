import { Component } from '@angular/core';
import { ContactService } from 'src/app/service/contact.service';

@Component({
  selector: 'app-contact-page',
  templateUrl: './contact-page.component.html',
  styleUrls: ['./contact-page.component.css'],
})
export class ContactPageComponent {
  errormessage = '';
  contacts: Contact[] = [];
  myemail: string = '';
  constructor(private contactService: ContactService) {}

  ngOnInit() {
    this.contactService.getContacts().subscribe((contacts) => {
      this.contacts = contacts;
    });
  }
  selectedContact: Contact | null = null;
  avatarList: string[] = [
    'assets/avatar1.png',
    'assets/avatar2.png',
    'assets/avatar3.png',
    'assets/avatar4.png',
    'assets/avatar5.png',
    'assets/avatar7.png',
    'assets/avatar8.png',
    'assets/avatar9.png',
    'assets/avatar10.png',
    'assets/avatar11.png',
    'assets/avatar12.png',
    'assets/avatar13.png',
    'assets/avatar14.png',
    'assets/avatar15.png',
    'assets/avatar16.png',
    'assets/avatar17.png',
    'assets/avatar18.png',
  ];
  addingContact: boolean = false;
  editingContact: Contact | null = null;

  editContactName(contact: Contact) {
    this.editingContact = contact;
  }

  toggleAddContact() {
    this.addingContact = true;
    this.errormessage = '';
  }

  cancelAddContact() {
    this.addingContact = false;
    this.myemail = '';
  }

  //Fonction qui permet d'ajouter un contact
  ajouterContact(email: string) {
    console.log('here');
    const emailData: AjoutContactDTO = { email: email };
    this.contactService.addContacts(emailData).subscribe(
      (newContacts) => {
        this.errormessage = '';
        this.contacts = newContacts;
      },
      (error) => {
        if (error.error.message === 'bad format') {
          this.errormessage = 'Le format attendu est nom_utilisateur@domaine !';
        }
      }
    );
    this.cancelAddContact();
  }

  //Fonction qui permet de créer la conversation avec le contact
  creerConversation(contact: Contact) {
    this.contactService.createConversation(contact.id).subscribe(() => {});
  }

  //Fonction qui permet de supprimer un contact
  supprimerContact(contactToDelete: Contact) {
    this.contactService
      .deleteContact(contactToDelete.id)
      .subscribe((newContacts) => {
        this.contacts = newContacts;
      });
  }

  getContactInfo(contact: Contact) {
    this.selectedContact = contact;
  }

  closeInfo() {
    this.selectedContact = null;
  }

  toggleEdit(contact: Contact) {
    contact.editMode = true;
  }

  //Permet de mettre à jour l'avatar du contact
  updateAvatar(newAvatar: string, contact: Contact) {
    this.contactService
      .updateContact(contact.id, 'avatar', newAvatar)
      .subscribe((newContacts) => {
        this.contacts = newContacts;
      });
    contact.editMode = false;
  }

  //Permet de mettre à jour le prénom du contact
  updateContactFirstName(newFirstname: string, contact: Contact) {
    this.contactService
      .updateContact(contact.id, 'firstname', newFirstname)
      .subscribe((newContacts) => {
        this.contacts = newContacts;
      });
    this.editingContact = null;
  }

  //Permet de mettre à jour le nom de famille du contact
  updateContactLastName(newLastname: string, contact: Contact) {
    this.contactService
      .updateContact(contact.id, 'lastname', newLastname)
      .subscribe((newContacts) => {
        this.contacts = newContacts;
      });
    this.editingContact = null;
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
  editMode?: boolean;
}

export interface UpdateInfoDTO {
  type: string;
  value: string;
}
