import { Civilite } from './civilite';
export class Fournisseur {
  public constructor(
    private _id?: number | undefined,
    private _prenom?: string | undefined,
    private _nom?: string | undefined,
    private _civilite?: Civilite | undefined,
    private _societe?: string | undefined
  ) {}

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter prenom
   * @return {string}
   */
  public get prenom(): string | undefined {
    return this._prenom;
  }

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter civilite
   * @return {Civilite}
   */
  public get civilite(): Civilite | undefined {
    return this._civilite;
  }

  /**
   * Getter societe
   * @return {string}
   */
  public get societe(): string | undefined {
    return this._societe;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter prenom
   * @param {string} value
   */
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter civilite
   * @param {Civilite} value
   */
  public set civilite(value: Civilite | undefined) {
    this._civilite = value;
  }

  /**
   * Setter societe
   * @param {string} value
   */
  public set societe(value: string | undefined) {
    this._societe = value;
  }
}
