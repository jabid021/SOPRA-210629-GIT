import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class CanActivateService implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    return localStorage.getItem('token') ? true : false;
  }
}
