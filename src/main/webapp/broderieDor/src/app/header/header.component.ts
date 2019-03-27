import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  isLogged = false;
  isLoggedOut = true;
  roles: string[];
  authority: string;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    if(this.tokenStorageService.getToken() != null){
      this.isLogged = true;
      this.isLoggedOut = false;
      this.roles = this.tokenStorageService.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN'){
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_VIP'){
          this.authority = 'vip';
          //return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }

  logout(){
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
