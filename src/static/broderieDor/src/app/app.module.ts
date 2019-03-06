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
import { LigneCommandeComponent } from './ligne-commande/ligne-commande.component';
import { ThemeComponent } from './theme/theme.component';
import { LignePanierComponent } from './ligne-panier/ligne-panier.component';

import { ProduitService } from './produit/produit.service';
import { ThemeService } from './theme/theme.service';
import { LigneCommandeService } from './ligne-commande/ligneCommande.service';
import { CommandeService } from './commande/commande.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CarouselComponent } from './carousel/carousel.component';
import { HomeComponent } from './home/home.component';
import { PanierComponent } from './panier/panier.component';
import { PanierService } from './panier/panier.service';
import { LignePanierService } from './ligne-panier/lignePanier.service';
import { DataService } from './dataService/DataService';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    ProduitComponent,
    CommandeComponent,
    LigneCommandeComponent,
    ThemeComponent,
    HeaderComponent,
    FooterComponent,
    CarouselComponent,
    HomeComponent,
    PanierComponent,
    LignePanierComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    ProduitService,
    ThemeService,
    LigneCommandeService,
    CommandeService,
    PanierService,
    LignePanierService,
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
