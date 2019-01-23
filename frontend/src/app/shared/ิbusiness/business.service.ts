import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BusinessService {

  constructor(private http: HttpClient) { }
  

  getProvince(): Observable<any> {
    return this.http.get('http://localhost:8080/Province');
  }

  getBusinessType(): Observable<any> {
    return this.http.get('http://localhost:8080/BusinessType');
  }
  postBusiness(myform){
    console.log(myform);
    return this.http.post('//localhost:8080/Business/Register/',myform);
  }

  login(email){
    return this.http.post('//localhost:8080/Business/login/',email);
  }

}
