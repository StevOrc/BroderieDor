import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { AuthService } from '../auth/auth.service';
import { SignUpInfo } from '../auth/signup-info';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  formSignUp: FormGroup;

  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  private signUpinfo: SignUpInfo;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.formSignUp = new FormGroup({
      lastName: new FormControl(),
      firstName: new FormControl(),
      username: new FormControl(),
      email: new FormControl(),
      password: new FormControl(),
      phone: new FormControl(),
      confirmPassword: new FormControl()
    })
  }

  onSubmit(){
    console.log(this.formSignUp);

    this.signUpinfo = new SignUpInfo(
      this.formSignUp.value.lastName,
      this.formSignUp.value.firstName,
      this.formSignUp.value.username,
      this.formSignUp.value.email,
      this.formSignUp.value.phone,
      this.formSignUp.value.password
    )

    this.authService.signUp(this.signUpinfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    )
  }
}
