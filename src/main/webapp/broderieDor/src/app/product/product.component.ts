import { Component, OnInit } from '@angular/core';

import { Product } from '../model/product';
import { ProductService } from './product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  listProduct: Product[];

  constructor(private productService: ProductService) {

  }

  ngOnInit() {
    this.getAllProduct();
  }

  getAllProduct(){
    this.productService.getAllProduits().subscribe(
      data => {this.listProduct = data},
      error => {console.log(error)},
      () => {console.log(this.listProduct)}
    )
  }

  test(){
    console.log("aaaaaaaa");
  }

}
