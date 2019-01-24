import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public API = '//localhost:8080'

  constructor(private http: HttpClient) { }

  private messageSource = new BehaviorSubject(JSON);
  currentMessage = this.messageSource.asObservable();

  getStoreList(): Observable<any> {
    return this.http.get(this.API + '/store');
  }

  getFoodList(): Observable<any> {
    return this.http.get(this.API + '/Food');
  }

  getOrderFoodList(): Observable<any> {
    return this.http.get(this.API + '/OrderFood');
  }

  getOrderFoodListById(storeId: number): Observable<any> {
    return this.http.get(this.API + '/Food/' + storeId);
  }

  getFoodById(foodId: number): Observable<any> {
    return this.http.get(this.API + '/Food/FindFood/' + foodId);
  }

  changeMessage(message) {
    this.messageSource.next(message)
  }

  addFoodOrder(profileId: number, storeId: number, foodId: number, countItem: number, totalPrice: number, deliverAddress: string) {
    return this.http.get(this.API + '/Order/'+profileId+'/'+storeId+'/'+foodId+'/'+countItem+'/'+totalPrice+'/'+deliverAddress);
  }

  public addOrder(confirmForm): Observable<any> {
    let result;
    result = this.http.post(this.API + '/Order/newOrder/', confirmForm);
    return result;
  }
}
