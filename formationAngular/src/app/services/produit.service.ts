import { Produit } from './../model/produit';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  constructor() {}

  public findAll(): Produit[] {
    return [new Produit('aaa', 1111), new Produit('mm', 222)];
  }
}
