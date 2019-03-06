import { Component, OnInit } from '@angular/core';

import { Produit } from '../model/produit';
import { ProduitService } from './produit.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {

  listProduit: Produit[];

  constructor(private produitService: ProduitService) {

  }

  ngOnInit() {
    this.getAllProduct();
  }

  getAllProduct(){
    this.produitService.getAllProduits().subscribe(
      data => {this.listProduit = data},
      error => {console.log(error)},
      () => {console.log(this.listProduit)}
    )
  }

}
