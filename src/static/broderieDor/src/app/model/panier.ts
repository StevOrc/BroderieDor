
import { Produit } from './produit';

export class Panier{

    constructor(
        public idPannier?: number,
        public nom?: string,
        public prix?: number,
        public idTheme?: number,
        public listProduits? : Produit[],
    ){

    }
}