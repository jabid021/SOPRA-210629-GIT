import { Produit } from './../model/produit';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fournisseur } from '../model/fournisseur';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  private url: string = 'http://localhost:8080/eshop/api/fournisseur';
  private headers: HttpHeaders | any = null;

  constructor(private http: HttpClient) {}

  private initHeaders() {
    this.headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('admin:admin'),
    });
  }

  public getAll(): Observable<Array<Fournisseur>> {
    this.initHeaders();
    return this.http.get<Array<Fournisseur>>(this.url, {
      headers: this.headers,
    });
  }

  public get(id: number): Observable<Fournisseur> {
    this.initHeaders();
    return this.http.get<Fournisseur>(
      `http://localhost:8080/eshop/api/fournisseur/${id}`,
      {
        headers: this.headers,
      }
    );
  }

  public delete(id: number | undefined) {
    this.initHeaders();
    return this.http.delete(`${this.url}/${id}`, {
      headers: this.headers,
    });
  }

  public update(fournisseur: Fournisseur): Observable<Fournisseur> {
    console.log(fournisseur);
    this.initHeaders();
    return this.http.put<Fournisseur>(
      `${this.url}/${fournisseur.id}`,
      fournisseur,
      {
        headers: this.headers,
      }
    );
  }

  public create(fournisseur: Fournisseur): Observable<Fournisseur> {
    this.initHeaders();
    const f = {
      prenom: fournisseur.prenom,
      nom: fournisseur.nom,
      civilite: fournisseur.civilite,
      societe: fournisseur.societe,
    };
    return this.http.post<Fournisseur>(this.url, f, { headers: this.headers });
  }
}
