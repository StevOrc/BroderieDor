import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-dashboard-client',
  templateUrl: './dashboard-client.component.html',
  styleUrls: ['./dashboard-client.component.css']
})
export class DashboardClientComponent implements OnInit {

  users: User[];
  selectedUser: User;
  isLogged = false;
  operation = '';
  succed = false;
  JSONResponse = '' ;
  constructor(private tokenService: TokenStorageService, private seriveAdmin: AdminService) {

  }

  ngOnInit() {
    if(this.tokenService.getToken()){
      this.isLogged = true;
      this.getAllUsers();
      console.log(this.JSONResponse.length)
    }
  }

  getAllUsers(){
    this.seriveAdmin.getAllUser().subscribe(
      data => {this.users = data},
      error => {console.log(error)}
    )
  }

  initOperation(){
    this.operation = '';
  }

  deleteUser(){
    this.seriveAdmin.deleteUser(this.selectedUser.idUser).subscribe(
      data => {this.JSONResponse = data.message; this.operation = 'SUCCED'},
      error => {console.log(error)}
    )
  }

  validAccount(){
    this.seriveAdmin.validUserAccount(this.selectedUser.idUser).subscribe(
      data => {this.JSONResponse = data.message; this.operation= 'SUCCED'},
      error => {console.log(error)}
    )
  }

  initPage(){
    this.reloadPage();
  }

  promo(promo: boolean){
    if(promo === false){
      this.seriveAdmin.deletePromo(this.selectedUser.idUser).subscribe(
        data => {this.reloadPage()},
        error => {console.log(error)}
      )
    }else if(promo === true){
      this.seriveAdmin.addPromo(this.selectedUser.idUser).subscribe(
        data => {this.reloadPage()},
        error => {console.log(error)}
      )
    }
  }

  reloadPage(){
    window.location.reload();
  }
}
