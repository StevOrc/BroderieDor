import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

import { Commande } from '../model/commande';

@Injectable()
export class DataService{

    private emitObject = new BehaviorSubject<Commande>(new Commande());
    
    commande = this.emitObject.asObservable();

    updateCommande(commande: Commande){
        this.emitObject.next(commande);
    }
}