import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ContactPageComponent } from './component/contact-page/contact-page.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { FormsModule } from '@angular/forms';
import { ContactBarreComponent } from './component/contact-barre/contact-barre.component';
import { MessageBlockComponent } from './component/message-block/message-block.component';
import { ContactBoxComponent } from './component/contact-box/contact-box.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { HomeComponent } from './component/home/home.component';
import { MessageContainerComponent } from './component/message-container/message-container.component';
import { OwnerBoxComponent } from './component/owner-box/owner-box.component';
import { MatButtonModule } from '@angular/material/button';
import { SettingsPageComponent } from './component/settings-page/settings-page.component';
import { ContactBannerComponent } from './component/contact-banner/contact-banner.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    InscriptionComponent,
    ContactBarreComponent,
    MessageBlockComponent,
    ContactBoxComponent,
    NavbarComponent,
    HomeComponent,
    ContactPageComponent,
    OwnerBoxComponent,
    MessageContainerComponent,
    SettingsPageComponent,
    ContactBannerComponent,
  ],
  imports: [
    BrowserModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
