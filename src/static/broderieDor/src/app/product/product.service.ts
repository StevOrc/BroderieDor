import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { API_URLS } from '../config/url.config';

@Injectable()
export class ProductService{


    constructor(private http: HttpClient){

    }

    getAllProduits(): Observable<any>{
        return this.http.get(API_URLS.PRODUITS_URL);
    }

}