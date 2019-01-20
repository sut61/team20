import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  public API = '//localhost:8080';
  public recipe = this.API+'/Recipe/';
 
  constructor(private http: HttpClient) { }
  getRecipe(id: string): Observable<any> {
    return this.http.get(this.recipe+id);
  }

}
