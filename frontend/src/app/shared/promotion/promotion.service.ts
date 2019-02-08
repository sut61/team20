import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class PromotionService {

  constructor(private http: HttpClient) { }
  getPercentage(): Observable<any> {
    return this.http.get('http://localhost:8080/Percentage');
  }

  getPromotionType(): Observable<any> {
    return this.http.get('http://localhost:8080/PromotionType');
  }

  getStore(email:string): Observable<any> {
    return this.http.get('http://localhost:8080/PromotionStore/'+email);
  }

  addPromotion(myform:NgForm){
    return this.http.post('http://localhost:8080/Promotion/',myform);
  }
}
