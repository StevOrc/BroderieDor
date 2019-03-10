import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { TokenStorageService } from '../auth/token-storage.service';
import { AdminService } from '../service/admin.service';
import { Theme } from '../model/theme';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.css']
})
export class ThemeComponent implements OnInit {

  isLogged = false;
  crudFormTheme: FormGroup;
  themes: Theme[];
  selectedTheme: Theme;
  operation = '';

  constructor(private tokenStorage: TokenStorageService, private adminService: AdminService) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.isLogged = true;
      this.getAllTheme();
      this.initForm();
    }
  }

  initForm(){
    this.crudFormTheme = new FormGroup({
      idTheme: new FormControl(),
      name: new FormControl(),
      description: new FormControl()
    })
  }

  getAllTheme(){
    this.adminService.getAllTheme().subscribe(
      data => {this.themes = data; console.log(this.themes)},
      error => {console.log(error)},
      () => {console.log("ALL THEME LOADED")}
    )
  }

  initTheme(){
    this.selectedTheme = new Theme();
    this.operation = 'ADD';
  }

  addTheme(){
    this.adminService.createTheme(this.selectedTheme).subscribe(
      data => { console.log(data); this.reloadPage() },
      error => { console.log(error)}
    )
  }

  updateTheme(){
    this.adminService.updateTheme(this.selectedTheme).subscribe(
      data => {console.log(data); this.reloadPage()},
      error => {console.log(error)}
    )
  }


  deleteTheme(){
    this.adminService.deleteTheme(this.selectedTheme.idTheme).subscribe(
      data => {console.log(data); this.reloadPage()},
      error => {console.log(error)}
    )
  }

  reloadPage(){
    window.location.reload();
  }
}
