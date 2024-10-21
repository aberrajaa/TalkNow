import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { HomeComponent } from './component/home/home.component';
import { ContactPageComponent } from './component/contact-page/contact-page.component';
import { SettingsPageComponent } from './component/settings-page/settings-page.component';
import { AuthGuardService } from './service/auth-guard.service';

const routes: Routes = [
  { path: '', component: ConnexionComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService] },
  { path: 'inscription', component: InscriptionComponent },
  {
    path: 'contact',
    component: ContactPageComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'parametres',
    component: SettingsPageComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'deconnexion',
    component: ConnexionComponent,
    canActivate: [AuthGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
