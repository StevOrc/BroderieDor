import { Component, OnInit} from '@angular/core';
import {Router} from "@angular/router"

import { Theme } from '../model/theme';
import { ThemeService } from '../service/theme.service';
import { Commande } from '../model/commande';
import { DataService } from '../dataService/DataService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  listThemes: Theme[];

  commande: Commande;

  constructor(public themeSerive: ThemeService, private route: Router, private dataService: DataService){ }

  ngOnInit() {
    this.allThemes();
    this.dataService.commande.subscribe(commande => this.commande = commande );
  }

  allThemes(){
    this.themeSerive.getAllThemes().subscribe(
      data => {this.listThemes = data; console.log(this.listThemes)},
      err => {console.log(err)},
      () => {console.log("all themes loaded")}
    )
  }

  createOrder(){
    this.commande.dateCommande = Date.now();
    console.log(this.commande);
    this.route.navigateByUrl("/commande");
  }

  test(){
    console.log("test !!");
  }
}
