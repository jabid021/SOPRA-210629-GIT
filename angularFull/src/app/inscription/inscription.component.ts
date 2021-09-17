import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { debounceTime, map } from 'rxjs/operators';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  prenom: FormControl;
  nom: FormControl;
  civilite: FormControl;
  dtNaiss: FormControl;
  login: FormControl;
  password: FormControl;
  confirm: FormControl;
  groupPassword: FormGroup;
  form: FormGroup;
  param: string = '';
  constructor(
    private fb: FormBuilder,
    private loginService: LoginService,
    private ar: ActivatedRoute,
    private router: Router
  ) {
    this.ar.queryParams.subscribe((params) => {
      if (params.source) {
        this.param = params.source;
      }
    });
    this.prenom = this.fb.control('', [
      Validators.required,
      Validators.minLength(3),
    ]);
    this.nom = this.fb.control('', [
      Validators.required,
      Validators.minLength(3),
    ]);
    this.dtNaiss = this.fb.control('', this.majeur);
    this.login = this.fb.control(
      '',
      Validators.required,
      this.controlLoginIsPresent()
    );
    this.password = this.fb.control('', [
      Validators.required,
      Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{5,})$/),
    ]);
    this.confirm = this.fb.control('', Validators.required);
    this.groupPassword = this.fb.group(
      {
        password: this.password,
        confirm: this.confirm,
      },
      { validators: this.controlEquals }
    );
    this.civilite = this.fb.control('');
    this.form = this.fb.group({
      prenom: this.prenom,
      nom: this.nom,
      civilite: this.civilite,
      dtNaiss: this.dtNaiss,
      login: this.login,
      groupPassword: this.groupPassword,
    });
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

  controlEquals(group: AbstractControl): ValidationErrors | null {
    let value1 = group.get('password')?.value;
    let value2 = group.get('confirm')?.value;
    if (group.get('password')?.errors) {
      return null;
    }
    return value1 != value2 ? { notEquals: true } : null;
  }

  majeur(control: AbstractControl): ValidationErrors | null {
    let dateNaissance = new Date(control.value);
    let age = (new Date().getTime() - dateNaissance.getTime()) / 31536000000;
    if (age > 18) {
      return null;
    } else {
      return { mineur: true };
    }
  }

  submit() {
    let client = {
      prenom: this.prenom.value,
      nom: this.nom.value,
      login: { login: this.login.value, password: this.password.value },
      dateNaissance: this.dtNaiss.value,
    };
    this.loginService.inscription(client).subscribe((res) => {
      if (this.param) {
        this.router.navigate(['/' + this.param]);
      } else {
        this.router.navigate(['/home']);
      }
    });
  }
}
