import { Produit } from './../model/produit';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  private url: string = 'http://localhost:8080/eshop/api/produit';

  constructor(private httpClient: HttpClient) {}
  public getAll(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(this.url);
  }

  delete(id: number | undefined) {
    return this.httpClient.delete(this.url + '/' + id);
  }

  public get(id: number): Observable<Produit> {
    return this.httpClient.get<Produit>(this.url + '/' + id);
  }

  public create(produit: Produit): Observable<Produit> {
    console.log(produit);
    const obj={
      libelle:produit.libelle,
      prix:produit.prix
    };
    return this.httpClient.post<Produit>(this.url, obj);
  }

  public update(produit: Produit): Observable<Produit> {
     return this.httpClient.put<Produit>(this.url + '/' + produit.id, produit);
  }
}
