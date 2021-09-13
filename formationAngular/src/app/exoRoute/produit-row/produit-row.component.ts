import { Produit } from './../../model/produit';
import { Component, OnInit, Input } from '@angular/core';
import { allProduits } from '../produits';

@Component({
  selector: '[produit-row]',
  templateUrl: './produit-row.component.html',
  styleUrls: ['./produit-row.component.css'],
})
export class ProduitRowComponent implements OnInit {
  @Input('produit')
  produitInitial: Produit = new Produit();

  @Input('index')
  index: number = -1;

  produit: Produit = new Produit();

  consultation: boolean = true;

  constructor() {}

  ngOnInit(): void {
    this.produit.nom = this.produitInitial.nom;
    this.produit.prix = this.produitInitial.prix;
  }

  edit() {
    this.consultation = false;
  }

  save() {
    this.produitInitial.nom = this.produit.nom;
    this.produitInitial.prix = this.produit.prix;
    this.consultation = true;
  }

  cancel() {
    this.consultation = true;
  }

  delete() {
    allProduits.splice(this.index, 1);
  }
}
