import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  Login = '//localhost:8080/validate';
  constructor(private http: HttpClient) { }

  login(data: any): Observable<any> {
    let result: Observable<Object>;
      result = this.http.post(this.Login,data);
    return result;
  }
}
