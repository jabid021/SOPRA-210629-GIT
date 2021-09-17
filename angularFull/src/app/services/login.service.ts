import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  public login(login: string, password: string): Observable<any> {
    let info = btoa(login + ':' + password);
    let headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${info}`,
    });
    return this.http.get(this.url, { headers: headers });
  }

  public inscription(client: Object): Observable<any> {
    console.log(client);
    return this.http.post(
      'http://localhost:8080/eshop/api/client/inscription',
      client
    );
  }
}
