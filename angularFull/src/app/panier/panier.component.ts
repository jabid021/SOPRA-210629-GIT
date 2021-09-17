import { ElementPanier } from './../model/element-panier';
import { Router } from '@angular/router';
import { PanierService } from './../services/panier.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css'],
})
export class PanierComponent implements OnInit {
  panier: Map<number, ElementPanier> = new Map();

  constructor(private panierService: PanierService, private router: Router) {}

  ngOnInit(): void {
    this.panier = this.panierService.panier;
    this.panier.forEach((v: ElementPanier, k: number) => {
      console.log('ligne' + k + ' ' + v);
    });
  }

  valider() {
    this.panierService.validerPanier().subscribe((res) => {
      this.panierService.resetPanier();
      alert('commande enregistree');
      this.router.navigate(['/home']);
    });
  }

  get log() {
    return localStorage.getItem('token');
  }
}
