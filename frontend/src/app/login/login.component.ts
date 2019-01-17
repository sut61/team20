import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgForm, Form } from '@angular/forms';
import { LoginService } from '../shared/login/login.service';
import { Profile } from 'selenium-webdriver/firefox';

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


constructor(private loginservice: LoginService,private router : Router,private route: ActivatedRoute) { }
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
            
            alert('EMAIL หรือ PASSWORD ไม่ถูกต้อง');
          
    
          }
          if(this.message==='{"message":"true"}'){
            this.loginservice.getUser().subscribe(
              data=>{
                      
                     console.log(data);
                     this.profiles=data;
           
            console.log(this.profiles);
             this.gotoManu();
            alert("ยินดีต้อนรับ   คุณ"+this.profiles.name);

                                    
            }

            );
            
            
            
           }
          
        
      console.log(data);
      },
      error => {
          console.log('Error', error);
          alert(' server ผิดพลาด ลองอีกครั้ง');
      }

      );
    }
  
  
  clear(){
    this.login.email = "";
    this.login.password = "";
    

}

}
