import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//Component Model
import { ContentComponent } from './content/content.component';
import { ProductComponent } from './product/product.component';
import { CommandeComponent } from './commande/commande.component';

import { ProductService } from './product/product.service';
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
import { ThemeComponent } from './dashboard-theme/theme.component';
import { DashboardBasketComponent } from './dashboard-basket/dashboard-basket.component';
import { DashboardClientComponent } from './dashboard-client/dashboard-client.component';
import { DashboardCommandeComponent } from './dashboard-commande/dashboard-commande.component';
import { DashboardProduitComponent } from './dashboard-produit/dashboard-produit.component';

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    ProductComponent,
    CommandeComponent,
    HeaderComponent,
    FooterComponent,
    CarouselComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    UserspaceComponent,
    ThemeComponent,
    DashboardBasketComponent,
    DashboardClientComponent,
    DashboardCommandeComponent,
    DashboardProduitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    ProductService,
    CommandeService,
    DataService,
    AdminService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
