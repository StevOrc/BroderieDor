import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductComponent } from './product/product.component';
import { CommandeComponent } from './commande/commande.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserspaceComponent } from './userspace/userspace.component';
import { ThemeComponent } from './dashboard-theme/theme.component';
import { DashboardBasketComponent } from './dashboard-basket/dashboard-basket.component';
import { DashboardClientComponent } from './dashboard-client/dashboard-client.component';
import { DashboardProduitComponent } from './dashboard-produit/dashboard-produit.component';

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
    component: ProductComponent
},
  {
    path: 'commande',
    component: CommandeComponent
},
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      {
        path: '',
        redirectTo: 'produit',
        pathMatch: 'full'
      },
      {
        path: 'produit',
        component: DashboardProduitComponent
      },
      {
        path: 'theme',
        component: ThemeComponent
      },
      {
        path: 'basket',
        component: DashboardBasketComponent
      },
      {
        path: 'client',
        component: DashboardClientComponent
      },
      {
        path: 'client',
        component: DashboardClientComponent
      },
      {
        path: '**',
        redirectTo: 'produit',
        pathMatch: 'full'
      }
    ]
},
  {
    path: 'userprofil',
    component: UserspaceComponent
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
