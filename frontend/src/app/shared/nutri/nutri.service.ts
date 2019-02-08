import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class NutriService {

  public API = '//localhost:8080';
  public Foodprop = this.API+'/Fooprop/';
  public Nutrivalue = this.API+'/Nutritive/';
  public Addnutrition = this.API+'/add-nutrition';

  constructor(private http: HttpClient) { }

  getFoodprop(id: string): Observable<any> {
    return this.http.get(this.Foodprop+id);
  }

  getNutrivalue(id: string): Observable<any> {
    return this.http.get(this.Nutrivalue+id);
  }

  addNutrition(Recipe:String,foodprop:string,amount:number,energy:number,fat:number,saturate:number,sodium:number,sugar:number){

      return this.http.post(this.Addnutrition,{
        'Recipe':Recipe,
        'prop':foodprop,
        'amount':amount,
        'energy':energy,
        'fat':fat,
        'saturates':saturate,
        'sodium':sodium,
        'sugar':sugar



      });

      

  }



}
