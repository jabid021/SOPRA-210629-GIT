export class Produit {
  public constructor(private _nom: string = '', private _prix: number = 0) {}

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Getter prix
   * @return {number }
   */
  public get prix(): number {
    return this._prix;
  }

  /**
   * Setter prix
   * @param {number } value
   */
  public set prix(value: number) {
    this._prix = value;
  }
}
