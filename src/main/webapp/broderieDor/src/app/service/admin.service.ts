import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { TokenStorageService } from '../auth/token-storage.service';
import { ADMIN_URLS } from '../config.url/CRUD.admin.url';
import { Product } from '../model/product';
import { Theme } from '../model/theme';
import { Basket } from '../model/basket';

@Injectable()
export class AdminService{

    header: HttpHeaders;

    constructor(private http: HttpClient, private tokenStorage: TokenStorageService){
        if(this.tokenStorage.getToken()){
            this.header = new HttpHeaders();
            this.header = this.header.append("Authorization", "Bearer " +this.tokenStorage.getToken());
            this.header = this.header.append("Content-type", "application/json");
        }
    }


    //Product CRUD service
    public getAllProduct(): Observable<any>{
        return this.http.get(ADMIN_URLS.ADMIN_PRODUCT_URL, {headers:this.header});
    }

    public deleteProduct(id): Observable<any>{
        return this.http.delete(ADMIN_URLS.ADMIN_PRODUCT_URL+'/'+`${id}`, {headers:this.header});
    }

    public updateProduct(product: Product): Observable<any>{
        return this.http.post(ADMIN_URLS.ADMIN_PRODUCT_UPDATE_URL, product, {headers:this.header});
    }

    public createProduct(product: Product): Observable<any>{
        return this.http.post(ADMIN_URLS.ADMIN_PRODUCT_CREATE_URL, product, {headers:this.header});
    }

    // Theme CRUD Service
    public getAllTheme(): Observable<any>{
        return this.http.get(ADMIN_URLS.ADMIN_THEME_URL, {headers:this.header});
    }

    public createTheme(theme: Theme): Observable<any>{
        return this.http.post(ADMIN_URLS.ADMIN_THEME_CREATE_URL, theme , {headers:this.header})
    }

    public updateTheme(theme: Theme): Observable<any>{
        return this.http.put(ADMIN_URLS.ADMIN_THEME_UPDATE_URL, theme , {headers:this.header})
    }

    public deleteTheme(id): Observable<any>{
        return this.http.delete(ADMIN_URLS.ADMIN_THEME_URL+'/'+`${id}`, {headers:this.header})
    }

    // Basket CRUD Service
    public getAllBasket(): Observable<any>{
        return this.http.get(ADMIN_URLS.ADMIN_BASKET_URL, {headers:this.header});
    }

    public createBasket(basket: Basket): Observable<any>{
        return this.http.post(ADMIN_URLS.ADMIN_BASKET_CREATE_URL, basket , {headers:this.header})
    }

    public updateBasket(basket: Basket): Observable<any>{
        return this.http.put(ADMIN_URLS.ADMIN_BASKET_UPDATE_URL, basket , {headers:this.header})
    }

    public deleteBasket(id): Observable<any>{
        return this.http.delete(ADMIN_URLS.ADMIN_BASKET_URL+'/'+`${id}`, {headers:this.header})
    }
}