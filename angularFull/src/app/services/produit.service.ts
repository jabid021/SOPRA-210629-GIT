import { Produit } from './../model/produit';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  private url: string = 'http://localhost:8080/eshop/api/produit';
  private headers: HttpHeaders | any = null;

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(this.url);
  }

  public initHeaders() {
    this.headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + localStorage.getItem('token'),
    });
  }

  delete(id: number | undefined) {
    this.initHeaders();
    return this.httpClient.delete(this.url + '/' + id, {
      headers: this.headers,
    });
  }

  public get(id: number): Observable<Produit> {
    this.initHeaders();
    return this.httpClient.get<Produit>(this.url + '/' + id, {
      headers: this.headers,
    });
  }

  public create(produit: Produit): Observable<Produit> {
    this.initHeaders();
    console.log(produit);
    const obj = {
      libelle: produit.libelle,
      prix: produit.prix,
    };
    return this.httpClient.post<Produit>(this.url, obj, {
      headers: this.headers,
    });
  }

  public update(produit: Produit): Observable<Produit> {
    this.initHeaders();
    return this.httpClient.put<Produit>(this.url + '/' + produit.id, produit, {
      headers: this.headers,
    });
  }
}
