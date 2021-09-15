import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
export class CustomValidator {
  //controle sans parametre
  public static pasOlivier(control: AbstractControl): ValidationErrors | null {
    if (control.value === 'olivier') {
      return { pasOlivier: true };
    } else {
      return null;
    }
  }

  public static pasTexte(texte: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      if (control.value === texte) {
        return { pasTexte: true };
      } else {
        return null;
      }
    };
  }
}
