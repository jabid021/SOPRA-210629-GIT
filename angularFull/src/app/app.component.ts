import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'angularFull';

  constructor(private router: Router) {}

  logout() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }

  get log(): boolean {
    return localStorage.getItem('token') ? true : false;
  }

  get role(): string | null {
    return localStorage.getItem('role');
  }
}
