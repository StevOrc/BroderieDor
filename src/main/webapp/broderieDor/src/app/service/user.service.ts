import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { USER_URLS } from '../config.url/CRUD.user';
import { TokenStorageService } from '../auth/token-storage.service'
import { User } from '../model/user';

@Injectable()
export class UserService{

    header: HttpHeaders;
    
    constructor(private http: HttpClient, private tokenStorageService: TokenStorageService){
        if(this.tokenStorageService.getToken()){
            this.header = new HttpHeaders();
            this.header = this.header.append("Authorization", "Bearer " +this.tokenStorageService.getToken());
            this.header = this.header.append("Content-type", "application/json");
        }
    }

    public getUser(username): Observable<any>{
        return this.http.get(USER_URLS.READ_USER_URL+'/'+`${username}`, {headers:this.header});
    }

    public  updateUser(user: {}): Observable<any>{
        return this.http.put(USER_URLS.UPDATE_USER_URL, user, {headers:this.header});
    }

}