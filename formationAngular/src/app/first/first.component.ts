import { Produit } from './../model/produit';
import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'first-component',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent implements OnInit {
  message = 'texte du component first';

  @Input('produitDansFirst')
  p: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  clickSurLeComponent() {
    console.log('click');
  }
}
