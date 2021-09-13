import { Produit } from '../../model/produit';
import { Component, OnInit } from '@angular/core';
import { allProduits } from '../produits';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produits: Produit[] = allProduits;
  constructor() {}

  ngOnInit(): void {}

  delete(index: number) {
    this.produits.splice(index, 1);
  }
}
