

export class LigneCommande{

    constructor(
        public idLigneCommande?: number,
        public quantite?: number,
        public prix?: number,
        public idCommande?: number,
        public idProduit?: number
    ){

    }
}