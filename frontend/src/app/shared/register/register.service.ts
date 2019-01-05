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
  constructor(private http: HttpClient) { }
  getprefix(): Observable<any> {
    return this.http.get(this.prefix);
  }

  getsex(): Observable<any> {
    return this.http.get(this.sex);
  }
}
