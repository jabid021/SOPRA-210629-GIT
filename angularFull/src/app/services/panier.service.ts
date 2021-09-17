import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ElementPanier } from './../model/element-panier';
import { Injectable } from '@angular/core';
import { Produit } from '../model/produit';

@Injectable({
  providedIn: 'root',
})
export class PanierService {
  private _panier: Map<number, ElementPanier> = new Map();

  constructor(private httpClient: HttpClient) {}

  public validerPanier(): Observable<any> {
    let tab: Array<Object> = [];
    this._panier.forEach((v: ElementPanier, k: number) => {
      tab.push({ idProduit: k, quantite: v.quantite });
    });
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + localStorage.getItem('token'),
    });
    return this.httpClient.post('http://localhost:8080/eshop/api/achat', tab, {
      headers: headers,
    });
  }

  public addProduit(produit: Produit): number {
    if (this._panier.get(produit.id!)) {
      this._panier.set(
        produit.id!,
        new ElementPanier(produit, this._panier.get(produit.id!)!.quantite + 1)
      );
    } else {
      this._panier.set(produit.id!, new ElementPanier(produit, 1));
    }
    return this._panier.get(produit.id!)?.quantite!;
  }

  public getQuantite(produit: Produit): number {
    return this._panier.get(produit.id!)?.quantite || 0;
  }

  public resetPanier() {
    this._panier = new Map();
  }

  public get panier(): Map<number, ElementPanier> {
    console.log('get panier:' + JSON.stringify(this._panier));
    return this._panier;
  }
}
