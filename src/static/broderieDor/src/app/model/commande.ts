
export class Commande{

    constructor(
        public client?: number,
        public prix?: number,
        public idProduit?: number,
        public nomProduit?: string,
        public dateCommande?: number
    ){

    }
}