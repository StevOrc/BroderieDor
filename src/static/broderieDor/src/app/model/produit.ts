
export class Produit{

    constructor(
        public idProduct?: number,
        public nom?: string,
        public prix?: number,
        public stock?: number,
        public urlPhoto?: string,
        public couleur?: string
    ){

    }
}