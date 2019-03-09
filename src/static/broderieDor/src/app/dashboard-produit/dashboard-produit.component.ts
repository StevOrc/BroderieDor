import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { AdminService } from '../service/admin.service';
import { Produit } from '../model/produit';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-dashboard-produit',
  templateUrl: './dashboard-produit.component.html',
  styleUrls: ['./dashboard-produit.component.css']
})
export class DashboardProduitComponent implements OnInit {

  isLogged = false;
  crudProductForm: FormGroup;
  produits: Produit[];
  selectedProduit: Produit;
  operation = '';

  constructor(private tokenStorage: TokenStorageService, private adminService: AdminService) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.getAllProducts(this.tokenStorage.getToken());
      this.isLogged = true;
      this.initCrudProductForm();
    }
  }
  
  getAllProducts(token){
    this.adminService.getAllProduct(token).subscribe(
      data => {this.produits = data; console.log(this.produits)},
      error => {console.log(error)},
      () => {console.log("ALL PRODUCT LOADED for ADMIN ONLY")}
    )
  }

  initCrudProductForm(){
    this.crudProductForm = new FormGroup({
      id: new FormControl(),
      price: new FormControl(),
      stock: new FormControl(),
      name: new FormControl(),
    })
  }

  initProduit(){
    this.selectedProduit = new Produit();
    this.operation = 'ADD';
  }

  updateProduct(){
    console.log(this.selectedProduit);
    this.adminService.updateProduct(this.tokenStorage.getToken(), this.selectedProduit).subscribe(
      data => {console.log(data); this.reloadPage()},
      error => {console.log(error)}
    )
  }

  addProduct(){
    this.selectedProduit.urlPhoto = 'photo.png';
    console.log(this.selectedProduit);
    this.adminService.createProduct(this.tokenStorage.getToken(), this.selectedProduit).subscribe(
      data => {console.log(data); this.reloadPage()},
      error => {console.log(error)}
    )
  }

  deleteProduct(){
    this.adminService.deleteProduct(this.tokenStorage.getToken(), this.selectedProduit.idProduct).subscribe(
      data => {console.log(data); this.reloadPage()},
      error => {console.log(error)}
    )
  }

  reloadPage(){
    window.location.reload();
  }

}
