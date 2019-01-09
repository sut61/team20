import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manu',
  templateUrl: './manu.component.html',
  styleUrls: ['./manu.component.css']
})
export class ManuComponent implements OnInit {

  profiles : any;

  constructor(private loginService:LoginService,private  router :Router) { }


  ngOnInit() {
    this.loginService.getUser().subscribe(
      data=>{
          try{
            this.profiles=data;
            console.log(this.profiles);
            //if(){}
           // else{
            alert("ยินดีต้อนรับ   คุณ"+this.profiles.name);
           // }
          }
          catch(Err){
              this.router.navigate(['/login']);
          }
            
      }
      

    );
  }

}
