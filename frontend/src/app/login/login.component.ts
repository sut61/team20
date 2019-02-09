import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgForm, Form } from '@angular/forms';
import { LoginService } from '../shared/login/login.service';
import { Profile } from 'selenium-webdriver/firefox';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
login : any = {};
message="";

user:string;
profiles :any;


constructor(private snackBar: MatSnackBar,private loginservice: LoginService,private router : Router,private route: ActivatedRoute) { }
  ngOnInit() {
    this.clear();

  }

  gotoManu(){
    this.router.navigate(['/manu']);

  }

  Login(form :Form){
    this.loginservice.login(form).subscribe(
      data => {
          this.message = JSON.stringify(data);

          if(this.message==='{"message":"false"}'){

           
            this.snackBar.open("EMAIL หรือ PASSWORD ไม่ถูกต้อง ", 'ลองใหม่', {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });


          }
          if(this.message==='{"message":"true"}'){
            this.loginservice.getUser().subscribe(
              data=>{
                      this.profiles=data;
                     
                      this.snackBar.open("ยินดีต้อนรับ   "+this.profiles.prefix.prefix+this.profiles.name, 'OK', {
                        duration: 10000,
                        verticalPosition:"top",
                        horizontalPosition: "center"
                      
                      });
                     this.gotoManu();



            }

            );



            }



      },
      error => {
          console.log('Error', error);
         // alert(' server ผิดพลาด ลองอีกครั้ง');
         this.snackBar.open("server ผิดพลาด ลองอีกครั้ง", 'OK', {
          duration: 10000,
          verticalPosition:"top",
          horizontalPosition: "center"
        
        });
       
         
      }

      );
    }


  clear(){
    this.login.email = "";
    this.login.password = "";


}

}
