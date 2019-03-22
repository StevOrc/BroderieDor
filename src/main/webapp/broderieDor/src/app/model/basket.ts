
import { BasketLine } from './basketLine';

export class Basket{

    idBasket?: number;
    name?: string;
    price?: number;
    theme?: string;
    basketLines? : BasketLine[];

    constructor(
        idBasket?: number,
        name?: string,
        price?: number,
        theme?: string,
        basketLines? : BasketLine[]
    ){
        this.idBasket = idBasket;
        this.name = name;
        this.price = price;
        this.theme = theme;
        this.basketLines = basketLines;
    }
}