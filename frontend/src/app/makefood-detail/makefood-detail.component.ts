import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import {RecipeService} from '../shared/recipe/recipe.service';

@Component({
  selector: 'app-makefood-detail',
  templateUrl: './makefood-detail.component.html',
  styleUrls: ['./makefood-detail.component.css']
})
export class MakefoodDetailComponent implements OnInit {

  sub: Subscription;
  Recipe:any ={};
 

  constructor(private RecipeService :RecipeService ,private route: ActivatedRoute,private router: Router) { }

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
    




      
      }
    });
   


  }

}
