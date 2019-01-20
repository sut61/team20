import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  public API = '//localhost:8080';
  public prefix = this.API+'/prefix';
  public sex = this.API+'/sex';
  public add = this.API+'/addprofiles';
  constructor(private http: HttpClient) { }
  getprefix(): Observable<any> {
    return this.http.get(this.prefix);
  }

  getsex(): Observable<any> {
    return this.http.get(this.sex);
  }

  save(profiles: any): Observable<any> {
    let result: Observable<Object>;
      result = this.http.post(this.add,profiles);
    return result;
  }
}
