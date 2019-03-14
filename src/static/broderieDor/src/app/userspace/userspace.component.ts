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

  constructor(private tokenStorage: TokenStorageService, private userService: UserService) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.isLogged = true;
      this.getUser();
    }
  }

  getUser(){

  }
}
