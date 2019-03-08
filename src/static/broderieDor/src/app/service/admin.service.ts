import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { TokenStorageService } from '../auth/token-storage.service';
import { ADMIN_URLS } from '../config/CRUD.admin.url';
import { Produit } from '../model/produit';

@Injectable()
export class AdminService{

    constructor(private http: HttpClient, private tokenStorage: TokenStorageService){

    }

    public getAllProduct(token: string): Observable<any>{
        let headers = new HttpHeaders();
        headers = headers.append("Authorization", "Bearer " +token);
        headers = headers.append("Content-type", "application/json");
        return this.http.get(ADMIN_URLS.ADMIN_PRODUCT_URL, {headers:headers});
    }

    public deleteProduct(token: string, id): Observable<any>{
        let headers = new HttpHeaders();
        headers = headers.append("Authorization", "Bearer " +token);
        headers = headers.append("Content-type", "application/json");
        return this.http.delete(ADMIN_URLS.ADMIN_PRODUCT_URL+'/'+`${id}`, {headers:headers});
    }

    public updateProduct(token: string, product: Produit): Observable<any>{
        let headers = new HttpHeaders();
        headers = headers.append("Authorization", "Bearer " +token);
        headers = headers.append("Content-type", "application/json");
        return this.http.post(ADMIN_URLS.ADMIN_UPDATE_URL, product, {headers:headers});
    }
}