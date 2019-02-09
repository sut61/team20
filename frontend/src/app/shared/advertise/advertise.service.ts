import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { NgForm } from '@angular/forms';
@Injectable({
  providedIn: 'root'
})
export class AdvertiseService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getStore(email: string): Observable<any> {
    return this.http.get(this.API + '/StoreAdvertise/' + email);
  }

  getAdvertisePackage(): Observable<any> {
    return this.http.get(this.API + '/AdvertisePackage');
  }

  registerAdvertise(myform: NgForm) {
    return this.http.post(this.API + '/RegiterShopAdvertise/', myform);
  }
  getShopAdvertise() {
    return this.http.get(this.API + '/ShopAdvertise');
  }
}
