import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { LogoComponent } from './logo/logo.component';
import {RouterModule, Routes} from "@angular/router";
import { PatientListComponent } from './patient-list/patient-list.component';
import { ProfileComponent } from './profile/profile.component';
import { FicheMedicaleComponent } from './fiche-medicale/fiche-medicale.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { FooterComponent } from './footer/footer.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'inscription', component: RegisterComponent },
  { path: 'patient', component: PatientListComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'fiche', component: FicheMedicaleComponent },
  { path: '**', component: PageNotFoundComponent },

];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    LogoComponent,
    PatientListComponent,
    ProfileComponent,
    FicheMedicaleComponent,
    PageNotFoundComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],

  exports: [
    RouterModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
