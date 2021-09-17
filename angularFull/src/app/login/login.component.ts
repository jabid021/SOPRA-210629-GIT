import { PanierService } from './../services/panier.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './../services/login.service';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  login: FormControl;
  password: FormControl;
  message: boolean = false;
  param: string = '';

  constructor(
    private panierService: PanierService,
    private ar: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    private loginService: LoginService
  ) {
    this.login = this.fb.control('', Validators.required);
    this.password = this.fb.control('', Validators.required);
    this.form = this.fb.group({
      login: this.login,
      password: this.password,
    });
    this.ar.queryParams.subscribe((params) => {
      this.param = params.source;
    });
  }

  submit() {
    this.loginService.login(this.login.value, this.password.value).subscribe(
      (ok) => {
        this.message = false;
        localStorage.setItem(
          'token',
          btoa(this.login.value + ':' + this.password.value)
        );
        localStorage.setItem('role', ok.role);
        localStorage.setItem('login', this.login.value);
        if (this.param) {
          this.panierService.validerPanier().subscribe((ok) => {
            this.router.navigate(['/' + this.param]);
          });
        } else {
          this.router.navigate(['/home']);
        }
      },
      (ko) => {
        this.message = true;
      }
    );
  }

  ngOnInit(): void {}
}
