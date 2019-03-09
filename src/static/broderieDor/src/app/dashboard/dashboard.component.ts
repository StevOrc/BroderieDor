import { Component, OnInit } from '@angular/core';

import { AdminService } from '../service/admin.service';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  isLogged = false;

  constructor(private tokenStorage: TokenStorageService, private adminService: AdminService) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.isLogged = true;
    }
  }


  reloadPage(){
    window.location.reload();
  }
}
