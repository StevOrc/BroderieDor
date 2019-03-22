import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-userspace',
  templateUrl: './userspace.component.html',
  styleUrls: ['./userspace.component.css']
})
export class UserspaceComponent implements OnInit {

  userForm: FormGroup;
  isLogged = false;
  currentUser: User = new User();
  main = true;
  operation = '';
  message = '';

  constructor(private tokenStorage: TokenStorageService, private userService: UserService) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.isLogged = true;
      this.getUser();
    }
  }

  getUser(){
    this.userService.getUser(this.tokenStorage.getUsername()).subscribe(
      data => {this.currentUser = data; console.log(this.currentUser)},
      error => {console.log(error)}
    )
  }

  onEditInitForm(){
    this.userForm = new FormGroup({
      idUser: new FormControl(),
      lastName: new FormControl(),
      firstName: new FormControl(),
      email: new FormControl(),
      username: new FormControl(),
      phone: new FormControl(),
    })
  }

  initUser(){

  }

  initOperation(){
    this.operation = '';
  }

  deleteUser(){

  }

  updateUser(){
    this.userForm.value.idUser = this.currentUser.idUser;
    console.log(this.userForm.value);
    this.userService.updateUser(this.userForm.value).subscribe(
      data => {this.message = data; this.successAction()},
      error => {console.log(error);  console.log("aaaaaa")}
    )
  }

  successAction(){
    this.operation = '';
    this.main = false;
  }

  reloadPage(){
    window.location.reload();
  }
}
