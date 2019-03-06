import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { API_URLS } from '../config/url.config';

@Injectable()
export class LigneCommandeService{


    constructor(private http: HttpClient){

    }

    getAllLigneCommandes(): Observable<any>{
        return this.http.get(API_URLS.LIGNE_COMMANDES_URL);
    }

}