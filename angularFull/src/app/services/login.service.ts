import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private url: string = 'http://localhost:8080/eshop/api/login';

  constructor(private http: HttpClient) {}

  public isPresent(login: string): Observable<boolean> {
    return this.http.get<boolean>(this.url + '/isPresent/' + login);
  }
}
