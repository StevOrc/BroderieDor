import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-userspace',
  templateUrl: './userspace.component.html',
  styleUrls: ['./userspace.component.css']
})
export class UserspaceComponent implements OnInit {

  isLogged = false;
  currentUser: User = new User();
  operation = '';

  constructor(private tokenStorage: TokenStorageService, private userService: UserService) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.isLogged = true;
      this.getUser();
    }
  }

  getUser(){
    this.userService.getUser(this.tokenStorage.getUsername()).subscribe(
      data => {this.currentUser = data},
      error => {console.log(error)}
    )
  }

  initOperation(){
    this.operation = '';
  }

  reloadPage(){
    window.location.reload();
  }
}
