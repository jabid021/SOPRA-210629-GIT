import { LoginService } from './../../services/login.service';
import { Observable } from 'rxjs';
import { debounceTime, map } from 'rxjs/operators';
import { CustomValidator } from './../../validators/custom-validator';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formulaire-code',
  templateUrl: './formulaire-code.component.html',
  styleUrls: ['./formulaire-code.component.css'],
})
export class FormulaireCodeComponent implements OnInit {
  monForm: FormGroup;
  monInput: FormControl;
  autreInput: FormControl;
  groupe1: FormGroup;
  texte: string = '';

  constructor(private fb: FormBuilder, private loginService: LoginService) {
    this.monInput = this.fb.control(
      '',
      [
        Validators.required,
        Validators.minLength(3),
        CustomValidator.pasOlivier,
        CustomValidator.pasTexte('bobo'),
      ],
      this.controlLoginIsPresent()
    );
    this.autreInput = this.fb.control('');
    this.groupe1 = this.fb.group(
      {
        input1: this.monInput,
        input2: this.autreInput,
      },
      {
        validators: this.controlEquals,
      }
    );

    this.monForm = this.fb.group({
      groupe1: this.groupe1,
    });
  }

  // controlEquals(group: FormGroup): ValidationErrors | null {
  //   let value1 = group.controls.input1.value;
  //   let value2 = group.controls['input2'].value;
  //   if (group.controls.input1.errors) {
  //     return null;
  //   }
  //   return value1 != value2 ? { notEquals: true } : null;
  // }

  controlEquals(group: AbstractControl): ValidationErrors | null {
    let value1 = group.get('input1')?.value;
    let value2 = group.get('input2')?.value;
    if (group.get('input1')?.errors) {
      return null;
    }
    return value1 != value2 ? { notEquals: true } : null;
  }

  submit() {
    this.texte = this.monInput.value;
    console.log(this.texte);
  }

  ngOnInit(): void {}

  controlLoginIsPresent(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.loginService.isPresent(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { isPresent: true } : null;
        })
      );
    };
  }
}
