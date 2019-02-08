import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NutriService } from '../shared/nutri/nutri.service';
@Component({
  selector: 'app-add-nutri',
  templateUrl: './add-nutri.component.html',
  styleUrls: ['./add-nutri.component.css']
})
export class AddNutriComponent implements OnInit {

  sub: Subscription;

  private id: any;
  private fooprop :string;
  private amount:number=0;
  private energy:number=0;
  private fat:number=0;
  private saturate:number=0;
  private sodium:number=0;
  private sugar:number=0;



  constructor(private NutriService :NutriService ,private route: ActivatedRoute,private router: Router) { }
  
  
  
  
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
      } 
    });

    }


  }

  









