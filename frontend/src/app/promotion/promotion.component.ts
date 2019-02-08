import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { PromotionService } from '../shared/promotion/promotion.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})
export class PromotionComponent implements OnInit {

  types:any;
  percentages:any;
  stores:any;
  email:string;

  constructor(private snackBar: MatSnackBar,private promotionService:PromotionService,private loginService:LoginService,private  router :Router) { }

  ngOnInit() {
    this.getPromotionType();
    this.getPercentage();
    this.loginService.getUser().subscribe(data => {
      try{
            
        this.email = data.email;
        console.log(this.email)
        this.getStore();
       }
       catch(Err){
           this.router.navigate(['/login']);
       }
    });
  }

  getPromotionType(){
    this.promotionService.getPromotionType().subscribe(data=>{
      this.types = data;
    })
  }

  getPercentage(){
    this.promotionService.getPercentage().subscribe(data=>{
      this.percentages = data;
    })
  }

  getStore(){
    this.promotionService.getStore(this.email).subscribe(data=>{
      this.stores = data;
      console.log(data);
    })
  }

  save(myform:NgForm){
    this.promotionService.addPromotion(myform).subscribe(data=>{
      this.snackBar.open("เพิ่มโปรโมชั่นแล้ว", 'ตกลง', {
        duration: 10000,
        verticalPosition:"top",
        horizontalPosition: "center"
      });
      this.router.navigate(['/manu']);
    },
    error => {
      this.snackBar.open("เกิดข้อผิดพลาด", 'ตกลง', {
        duration: 10000,
        verticalPosition:"top",
        horizontalPosition: "center"
      });
    });
  }

}
