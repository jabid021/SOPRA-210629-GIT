import { Produit } from './../model/produit';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'show-produit',
  templateUrl: './show-produit.component.html',
  styleUrls: ['./show-produit.component.css'],
})
export class ShowProduitComponent implements OnInit {
  @Input()
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}
}
