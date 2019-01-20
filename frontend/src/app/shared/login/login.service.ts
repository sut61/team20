import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  Login = '//localhost:8080/validate';
  Email = '//localhost:8080/getuser';
   name;
   

  constructor(private http: HttpClient) { }
   checkout: {email :" ",password:" "};
  login(data: any): Observable<any> {
    let result: Observable<Object>;
      result = this.http.post(this.Login,data);
    return result;
  }
  getUser(): Observable<any> {
    let result: Observable<Object>;
      result = this.http.get(this.Email);
    return result;
  }

  logout(): Observable<any> {
    let result: Observable<Object>;
    
      result = this.http.post(this.Login,{email:"",pasword:""});
    return result;
  }

  
}
