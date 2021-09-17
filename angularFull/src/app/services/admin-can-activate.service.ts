import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AdminCanActivateService implements CanActivate {
  constructor() {}

  canActivate(): boolean {
    return localStorage.getItem('role') === 'ROLE_ADMIN' ? true : false;
  }
}
