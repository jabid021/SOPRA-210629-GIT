import { Produit } from './../model/produit';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css'],
})
export class FormProduitComponent implements OnInit {
  produit: Produit = new Produit();

  @Output()
  produitReady: EventEmitter<Produit> = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  public send() {
    this.produitReady.emit(this.produit);
    this.produit = new Produit();
  }
}
