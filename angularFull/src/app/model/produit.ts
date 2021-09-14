export class Produit {
  public constructor(
    private _id?: number,
    private _libelle?: string,
    private _prix?: number
  ) {}

  /**
   * Getter id
   * @return {number}
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter libelle
   * @return {string}
   */
  public get libelle(): string | undefined {
    return this._libelle;
  }

  /**
   * Getter prix
   * @return {number}
   */
  public get prix(): number | undefined {
    return this._prix;
  }

  /**
   * Setter id
   * @param {number} value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter libelle
   * @param {string} value
   */
  public set libelle(value: string | undefined) {
    this._libelle = value;
  }

  /**
   * Setter prix
   * @param {number} value
   */
  public set prix(value: number | undefined) {
    this._prix = value;
  }
}
