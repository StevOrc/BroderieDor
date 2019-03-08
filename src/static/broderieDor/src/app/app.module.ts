import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//Component Model
import { ContentComponent } from './content/content.component';
import { ProduitComponent } from './produit/produit.component';
import { CommandeComponent } from './commande/commande.component';

import { ProduitService } from './produit/produit.service';
//import { ThemeService } from './service/theme.service';
import { CommandeService } from './commande/commande.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CarouselComponent } from './carousel/carousel.component';
import { HomeComponent } from './home/home.component';
import { DataService } from './dataService/DataService';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserspaceComponent } from './userspace/userspace.component';
import { AdminService } from './service/admin.service';
import { UserService } from './service/user.service';

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    ProduitComponent,
    CommandeComponent,
    HeaderComponent,
    FooterComponent,
    CarouselComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    UserspaceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    ProduitService,
    CommandeService,
    DataService,
    AdminService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
