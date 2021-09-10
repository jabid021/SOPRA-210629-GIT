export class Personne {
  // private _prenom: string;
  // private _nom: string;

  // public constructor(prenom: string, nom: string) {
  //   this._prenom = prenom;
  //   this._nom = nom;
  // }

  public constructor(private _prenom: string = '', private _nom: string = '') {}

  public get infos(): string {
    return this.prenom + ' ' + this.nom;
  }

  /**
   * Getter prenom
   * @return {string}
   */
  public get prenom(): string {
    return this._prenom;
  }

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Setter prenom
   * @param {string} value
   */
  public set prenom(value: string) {
    this._prenom = value;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string) {
    this._nom = value;
  }
}
