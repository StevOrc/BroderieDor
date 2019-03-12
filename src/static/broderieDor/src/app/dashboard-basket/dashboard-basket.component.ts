import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray, FormBuilder } from '@angular/forms';

import { TokenStorageService } from '../auth/token-storage.service';
import { AdminService } from '../service/admin.service';
import { Basket } from '../model/basket';
import { Theme } from '../model/theme';
import { Product } from '../model/product';

@Component({
  selector: 'app-dashboard-basket',
  templateUrl: './dashboard-basket.component.html',
  styleUrls: ['./dashboard-basket.component.css']
})
export class DashboardBasketComponent implements OnInit {

  baskets: Basket[];
  themes: Theme[];
  products: Product[];
  selectedBasket: Basket;
  isLogged = false;
  crudBasketForm: FormGroup;
  operation = '';

  constructor(private tokenStorage: TokenStorageService, private adminService: AdminService, private fb: FormBuilder) { }

  ngOnInit() {
    if(this.tokenStorage.getToken()){
      this.isLogged = true;
      this.initFormGroup();
      this.getAllBasket();
      this.getAllTheme();
      this.getAllProducts();
    }
  }

  initFormGroup(){
    this.crudBasketForm = this.fb.group({
      name: [],
      price: [],
      theme: [],
      basketLines: this.fb.array([this.addLines()])
    })
  }

  addLines(){
    return this.fb.group({
      quantity: [],
      idProduct: [],
    })
  }

  get basketLinesArray(){
    return <FormArray>this.crudBasketForm.get('basketLines');
  }

  initBasket(){
    this.selectedBasket = new Basket();
    this.operation = 'ADD';
    this.initFormGroup();
  }

  addBasketLinesArray(lines?: FormGroup){
    if(lines){
      this.basketLinesArray.push(lines);
      return;
    }
    this.basketLinesArray.push(this.addLines());
  }

  deleteBasketLinesArray(index){
    this.basketLinesArray.removeAt(index);
  }

  onEditInitForm(){
    this.initFormGroup();
    for(let i=0; i < this.selectedBasket.basketLines.length; i++){
      let tempForm = new FormControl(this.selectedBasket);
      let form = new FormGroup({
        quantity: new FormControl(tempForm.value.basketLines[i].quantity),
        idProduct: new FormControl(tempForm.value.basketLines[i].product.idProduct)
      })
      this.addBasketLinesArray(form);
    }
    this.deleteBasketLinesArray(0);
  }

  getAllBasket(){
    this.adminService.getAllBasket().subscribe(
      data => {this.baskets = data; console.log(this.baskets)},
      error => {console.log(error)},
    )
  }

  getAllProducts(){
    this.adminService.getAllProduct().subscribe(
      data => {this.products = data},
      error => {console.log(error)}
    )
  }

  getAllTheme(){
    this.adminService.getAllTheme().subscribe(
      data => {this.themes = data},
      error => { console.log(error)}
    )
  }

  createBasket(){
    this.selectedBasket.basketLines = this.crudBasketForm.controls.basketLines.value;
    console.log(this.crudBasketForm);
    console.log(this.selectedBasket);
  }

  updateBasket(){
    console.log(this.crudBasketForm);
    let basketTemp: Basket = new Basket(
      this.crudBasketForm.controls.name.value,
      this.crudBasketForm.value.price,
      this.crudBasketForm.controls.theme.value.name,
      this.crudBasketForm.value.basketLines
    );
  }

  deleteBasket(){
  }

  initOperation(){
    this.operation = '';
  }

  reloadPage(){
    window.location.reload();
  }

  reloadForm(){
    this.initFormGroup();
  }

}
