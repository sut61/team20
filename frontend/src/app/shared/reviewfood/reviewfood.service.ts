import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class ReviewfoodService {

  
  public API = '//localhost:8080';
  public pointfood = this.API+'/pointfood';
  public foodall = this.API+'/foodall';
  public add = this.API+'/addfoodforreview';
  constructor(private http: HttpClient) { }

  
  getpointfood(): Observable<any> {
    return this.http.get(this.pointfood);
   
  }

  getAllfood(): Observable<any> {

    return this.http.get(this.foodall);
    
  }


  save(reviewfood: any): Observable<any> {
    let result: Observable<Object>;
      result = this.http.post(this.add,reviewfood);
    return result;
  }
}

