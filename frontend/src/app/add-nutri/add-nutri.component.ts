import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NutriService } from '../shared/nutri/nutri.service';
import {RecipeService} from '../shared/recipe/recipe.service';

@Component({
  selector: 'app-add-nutri',
  templateUrl: './add-nutri.component.html',
  styleUrls: ['./add-nutri.component.css']
})
export class AddNutriComponent implements OnInit {

  sub: Subscription;
  private recipe:any={};
  private id: any;
  private fooprop :string;
  private amount:number;
  private energy:number;
  private fat:number;
  private saturate:number;
  private sodium:number;
  private sugar:number;



  constructor(private NutriService :NutriService ,private route: ActivatedRoute,private router: Router ,private RecipeService: RecipeService) { }
  
  
  
  
  AddNutrition(){
      
    this.NutriService.addNutrition(this.id,this.fooprop,this.amount,this.energy,this.fat,this.saturate,this.sodium,this.sugar).subscribe(data=>{

                  console.log( "Update Success" , data) ;           
                  if(data == true){
                    this.router.navigate(['/makefood-list']);
                    alert('เพิ่มสูตรอาหารเรียบร้อย');}
                  else alert('ไม่สามารถแก้ไขได้ server ผิดพลาดหรือไม่มีข้อมูล');

        },
        error =>{
                  console.log("Fail Success", error);
                  alert('ไม่สามารถแก้ไขได้ server ผิดพลาดหรือไม่มีข้อมูล');
                })
                                  
  
  }
  
  
  
  
  
  
  
  
  
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = params['id'];
      if(this.id){
          console.log('is id ',this.id);
          this.RecipeService.getRecipe(this.id).subscribe(
            body => {
              this.recipe = body;
            
              console.log("GET Request is successful ", body);
            },error => {console.log("Error", error);}
          );  

      } 
    });

    }


  }

  









