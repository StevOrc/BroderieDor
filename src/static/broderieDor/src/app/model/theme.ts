
import { Panier } from './panier';

export class Theme{

    constructor(
        public idTheme?: number,
        public nom?: string,
        public paniers?: Panier[]
    ){
        
    }
}