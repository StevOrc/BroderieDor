import { Injectable } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

import { TokenStorageService } from './token-storage.service';

const TOKEN_HEADER_KEY = 'Authorization';

// création d'un service interceptor grace angular HttpInterceptor avec la méthode intercept()
// pour inspecter et tranformer les requêtes http avant qu'elles soient envoyés au serveur
// Avant l'envoi on set la key 'Authorization' du header qui sera de type Bearer
@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{

  constructor(private token: TokenStorageService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler){

    let authReq = req;
    const token = this.token.getToken();
    if(token != null){
      authReq = req.clone({
        headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' +token)
      });
    }

    return next.handle(authReq);
  }
}

export const httpInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true }
];

/*
The HTTPRequest object will be inspected and forwarded to handle() method of the HttpHandler object.
handle() method transforms HTTPRequest object into an Observable of HttpEvents which includes the server’s response.
This object represents the next interceptor in the chain of interceptors. The final ‘next’ in the chain is the Angular HttpClient handler.
*/