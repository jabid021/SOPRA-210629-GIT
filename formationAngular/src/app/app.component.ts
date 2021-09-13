import { Produit } from './model/produit';
import { Personne } from './model/personne';
import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  couleur: string = '#00000';
  messageRecupere: string = '';

  produit: Produit = new Produit();

  traitementEvent(message: string) {
    this.messageRecupere = message;
  }

  getProduit(produit: Produit) {
    this.produit = produit;
  }
}
