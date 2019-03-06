import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { API_URLS } from '../config/url.config';

@Injectable()
export class LignePanierService{


    constructor(private http: HttpClient){

    }

    getAllLignePaniers(): Observable<any>{
        return this.http.get(API_URLS.LIGNE_PANIERS_URL);
    }

}