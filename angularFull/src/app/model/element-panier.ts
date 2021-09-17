import { Produit } from './produit';
export class ElementPanier {
  public constructor(private _produit: Produit, private _quantite: number) {}

  /**
   * Getter produit
   * @return {Produit}
   */
  public get produit(): Produit {
    return this._produit;
  }

  /**
   * Getter quantite
   * @return {number}
   */
  public get quantite(): number {
    return this._quantite;
  }

  /**
   * Setter produit
   * @param {Produit} value
   */
  public set produit(value: Produit) {
    this._produit = value;
  }

  /**
   * Setter quantite
   * @param {number} value
   */
  public set quantite(value: number) {
    this._quantite = value;
  }
}
