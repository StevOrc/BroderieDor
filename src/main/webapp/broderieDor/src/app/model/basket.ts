
import { BasketLine } from './basketLine';

export class Basket{

    idBasket?: number;
    name?: string;
    price?: number;
    theme?: string;
    basketLines? : BasketLine[];
    urlPhoto? : string;

    constructor(
        idBasket?: number,
        name?: string,
        price?: number,
        theme?: string,
        basketLines? : BasketLine[],
        urlPhoto?: string
    ){
        this.idBasket = idBasket;
        this.name = name;
        this.price = price;
        this.theme = theme;
        this.basketLines = basketLines;
        this.urlPhoto = urlPhoto;
    }
}