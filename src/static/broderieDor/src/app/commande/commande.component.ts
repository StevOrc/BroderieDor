import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators} from '@angular/forms';

import { Commande } from '../model/commande';
import { CommandeService } from './commande.service';
import { DataService } from '../dataService/DataService';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {


  commande: Commande;

  listCommandes: Commande[];
  isValidated: false;

  constructor(private commandeService?: CommandeService, private dataService?: DataService) { }

  ngOnInit() {
    this.dataService.commande.subscribe(commande => this.commande = commande );
  }

  newCommande(){
  }

  displayCommande(){
    console.log(this.commande);
  }
}
