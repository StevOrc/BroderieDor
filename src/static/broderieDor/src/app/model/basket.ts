
import { Product } from './product';

export class Basket{

    constructor(
        public idPannier?: number,
        public nom?: string,
        public prix?: number,
        public idTheme?: number,
        public listProduits? : Product[],
    ){

    }
}