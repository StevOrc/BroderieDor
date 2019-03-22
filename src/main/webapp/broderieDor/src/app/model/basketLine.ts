

export class BasketLine{

    idBasketLine: number;
    quantity: number;
    idProduct: number;

    constructor(quantity: number, idProduct: number, idBasketLine?: number){
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.idBasketLine = idBasketLine;
    }
}