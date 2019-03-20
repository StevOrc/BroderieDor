
import { Commande } from '../model/commande';

export class User{
    idUser: number;
    lastName: string;
    firstName: string;
    email: string;
    phone: string;
    commandes: Commande[];

    constructor(){

    }
}