import { allProduits } from '../produits';
import { Produit } from '../../model/produit';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.css'],
})
export class ProduitDetailComponent implements OnInit {
  produit: Produit = new Produit();
  index: number = -1;

  constructor(private ar: ActivatedRoute, private router: Router) {
    ar.params.subscribe((params) => {
      if (params.index) {
        this.index = params.index;
        this.produit.nom = allProduits[params.index].nom;
        this.produit.prix = allProduits[params.index].prix;
      }
    });
  }

  ngOnInit(): void {}

  save() {
    if (this.index === -1) {
      allProduits.push(this.produit);
    } else {
      allProduits[this.index] = this.produit;
    }
    this.router.navigate(['/produits'], { queryParams: { save: this.index } });
  }
}
