import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { API_URLS } from '../config/url.config';
import{ Panier } from '../model/panier';

@Injectable()
export class PanierService{

    listPaniers: Panier[];

    constructor(private http: HttpClient){

    }

    getAllPaniers(): Observable<any>{
        return this.http.get(API_URLS.PANIERS_URL);
    }

}