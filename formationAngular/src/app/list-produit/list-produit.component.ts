import { Produit } from './../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Produit[] = [
    new Produit('telephone', 500),
    new Produit('voiture', 20000),
  ];

  filtre: string = '';

  info(produit: Produit) {
    if (produit.prix < 0) {
      return 'negatif';
    } else if (produit.prix > 0) {
      return 'positif';
    } else {
      return 'neutre';
    }
  }

  getProduit(produit: Produit) {
    this.produits.push(produit);
  }

  produitsFiltres() {
    return this.produits.filter((p) => {
      return p.nom.indexOf(this.filtre) !== -1;
    });
  }

  constructor() {}

  ngOnInit(): void {}
}
