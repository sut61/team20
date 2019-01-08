import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatSelectModule,MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';


import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MakefoodListComponent } from './makefood-list/makefood-list.component';
import { MakefoodAddComponent } from './makefood-add/makefood-add.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import {MatBadgeModule} from '@angular/material/badge';
import { RegisterService} from './shared/register/register.service';
import { HttpClientModule } from '@angular/common/http';
import { ManuComponent } from './manu/manu.component';
import { LoginService} from './shared/login/login.service';
import { environment } from '../environments/environment';
import { AngularFireStorageModule,StorageBucket } from '@angular/fire/storage';
import { AngularFireModule } from '@angular/fire';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    RegisterComponent,
    ManuComponent,
    MakefoodAddComponent,
    MakefoodListComponent
  ],


  imports: [
    BrowserModule,
    FormsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatBadgeModule,
    MatSelectModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireStorageModule


  ],

  providers: [RegisterService,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
