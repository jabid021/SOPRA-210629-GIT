import { Produit } from './../../model/produit';
import { ProduitService } from './../../services/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.produitService.getAll().subscribe((res) => {
      console.log(res);
      this.produits = res;
    });
  }

  get admin() {
    return localStorage.getItem('role') === 'ROLE_ADMIN';
  }
}
