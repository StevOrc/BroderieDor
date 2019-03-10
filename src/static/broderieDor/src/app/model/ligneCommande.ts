

export class OrderLine{

    constructor(
        public idOrderLine?: number,
        public quantity?: number,
        public price?: number,
        public idCommande?: number,
        public idProduct?: number
    ){

    }
}