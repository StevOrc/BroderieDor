import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProduitComponent } from './produit/produit.component';
import { ThemeComponent } from './theme/theme.component';
import { CommandeComponent } from './commande/commande.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [ 
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: RegisterComponent
  },
  {
    path: 'produit', 
    component: ProduitComponent
},
  {
    path: 'theme',
    component: ThemeComponent
},
  {
    path: 'commande',
    component: CommandeComponent
},
  {
    path: 'dashboard',
    component: DashboardComponent
},
  {
    path: '', 
    redirectTo: 'home', 
    pathMatch: 'full'
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
