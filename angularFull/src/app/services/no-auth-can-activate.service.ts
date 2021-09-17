import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class NoAuthCanActivateService implements CanActivate {
  constructor() {}

  canActivate(): boolean {
    return localStorage.getItem('token') ? false : true;
  }
}
