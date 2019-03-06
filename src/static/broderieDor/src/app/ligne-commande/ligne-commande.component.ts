import { Component, OnInit } from '@angular/core';

import { LigneCommande} from '../model/ligneCommande';

@Component({
  selector: 'app-ligne-commande',
  templateUrl: './ligne-commande.component.html',
  styleUrls: ['./ligne-commande.component.css']
})
export class LigneCommandeComponent implements OnInit {

  listLigneCommandes: LigneCommande[];

  constructor() { }

  ngOnInit() {
  }

}
