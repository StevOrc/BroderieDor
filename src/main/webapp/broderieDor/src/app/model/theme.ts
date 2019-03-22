
import { Basket } from './basket';

export class Theme{

    constructor(
        public idTheme?: number,
        public name?: string,
        public description?: string,
        public baskets?: Basket[]
    ){
        
    }
}