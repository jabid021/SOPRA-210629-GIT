import { PanierService } from './../../services/panier.service';
import { Produit } from './../../model/produit';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'achat',
  templateUrl: './achat.component.html',
  styleUrls: ['./achat.component.css'],
})
export class AchatComponent implements OnInit {
  @Input()
  produit: Produit | undefined;
  quantite: number = 0;

  constructor(private panierService: PanierService) {}

  ngOnInit(): void {
    this.quantite = this.panierService.getQuantite(this.produit!) || 0;
  }

  addPanier() {
    this.quantite = this.panierService.addProduit(this.produit!);
  }
}
