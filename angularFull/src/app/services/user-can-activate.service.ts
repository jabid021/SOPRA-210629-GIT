import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserCanActivateService implements CanActivate {
  constructor() {}

  canActivate(): boolean {
    return localStorage.getItem('role') === 'ROLE_USER' ? true : false;
  }
}
