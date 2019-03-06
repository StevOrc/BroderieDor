import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { AuthService } from '../auth/auth.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { AuthLoginInfo } from '../auth/login-info';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup;
  isLoggedIn =  false;
  isLoginFailed = false;
  errormessage =  '';
  username = '';
  roles: string[] = [];
  private logInfo: AuthLoginInfo;

  constructor(private tokenService : TokenStorageService, private authService: AuthService) { }

  ngOnInit() {
    this.formLogin = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
    })
    if(this.tokenService.getToken()){
      this.isLoggedIn = true;
      this.roles = this.tokenService.getAuthorities();
      this.username = this.tokenService.getUsername();
    }
  }
   onSubmit(){
     console.log(this.formLogin);
         // On récupère Username et Password dans l'objet AuthLoginInfo
      this.logInfo = new AuthLoginInfo(
      this.formLogin.value.username,
      this.formLogin.value.password);

      this.authService.attemptAuth(this.logInfo).subscribe(
        data => {
          // Si tout est ok, on sauve les datas dans le storage du browser
          this.tokenService.saveToken(data.accessToken);
          this.tokenService.saveUsername(data.username);
          this.tokenService.saveAuthorities(data.authorities);
   
          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.roles = this.tokenService.getAuthorities();
          this.reloadPage();
        },
        error => {
          console.log(error);
          this.errormessage = error.error.message;
          this.isLoginFailed = true;
        }
      );
   }

   reloadPage(){
    window.location.reload();
   }
}
