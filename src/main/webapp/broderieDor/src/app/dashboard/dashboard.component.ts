import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router'

import { AdminService } from '../service/admin.service';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  isLogged = false;

  constructor(private tokenStorage: TokenStorageService, private adminService: AdminService,
    private route: Router, private activeRoute: ActivatedRoute
    )
    { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.isLogged = true;
    }
  }

  productView(){
    this.route.navigate(['produit'], {relativeTo: this.activeRoute})
  }

  themeView(){
    this.route.navigate(['theme'], {relativeTo: this.activeRoute})
  }

  clientView(){
    this.route.navigate(['client'], {relativeTo: this.activeRoute})
  }

  commandeView(){
    this.route.navigate(['commande'], {relativeTo: this.activeRoute})
  }

  basketView(){
    this.route.navigate(['basket'], {relativeTo: this.activeRoute})
  }

  reloadPage(){
    window.location.reload();
  }
}
