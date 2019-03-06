import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { API_URLS } from '../config/url.config';

@Injectable()
export class CommandeService{

    constructor(private http: HttpClient){

    }

    getAllCommandes(): Observable<any>{
        return this.http.get(API_URLS.COMMANDES_URL);
    }

}