import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import {RecipeService} from '../shared/recipe/recipe.service';
import { NutriService } from '../shared/nutri/nutri.service';

@Component({
  selector: 'app-makefood-detail',
  templateUrl: './makefood-detail.component.html',
  styleUrls: ['./makefood-detail.component.css']
})
export class MakefoodDetailComponent implements OnInit {

  sub: Subscription;
  Recipe:any ={};
  FoodProp:any={};
  NutriValue:any={};

  constructor(private RecipeService :RecipeService ,private route: ActivatedRoute,private router: Router ,private NutriService:NutriService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if(id){
          console.log('is id ',id);
          this.RecipeService.getRecipe(id).subscribe(
            body => {
              this.Recipe = body;
            
              console.log("GET Request is successful ", body);
            },error => {console.log("Error", error);}
          );  
          
          this.NutriService.getFoodprop(id).subscribe(
            
              body=>{
                this.FoodProp=body;
              }
            
            ,error =>{console.log("Error", error);}

          );

          this.NutriService.getNutrivalue(id).subscribe(
            
            body=>{
              this.NutriValue=body;
            }
          
          ,error =>{console.log("Error", error);}

        );
    




      
      }
    });
   


  }

}
