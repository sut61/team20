import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { BusinessService } from '../shared/ิbusiness/business.service';
import { NgForm } from '@angular/forms';
import { stringify } from 'querystring';

@Component({
  selector: 'app-manu',
  templateUrl: './manu.component.html',
  styleUrls: ['./manu.component.css']
})
export class ManuComponent implements OnInit {

  profiles: any;


  constructor(private loginService: LoginService, private router: Router, private businessService: BusinessService) { }


  ngOnInit() {
    this.loginService.getUser().subscribe(
      data => {
        try {
          this.profiles = data;

          console.log(this.profiles.name);


          // alert("ยินดีต้อนรับ   คุณ"+this.profiles.name);

        }
        catch (Err) {
          this.router.navigate(['/login']);
        }

      }


    );
  }

  Logout() {



    this.loginService.logout().subscribe(
      data => {

        this.router.navigate(['/login']);
        console.log(data);

      }
    );

  }
  email(email: any): any {
    throw new Error("Method not implemented.");
  }
  checkbusiness() {
    let form:any = {
        "email": String
    };
    form.email = this.profiles.email;
    this.businessService.login(form).subscribe(data => {
      console.log(data);
    },
      error => {
        console.log("Error", error);
        alert("ยังไม่ได้สมัคร");
        this.router.navigate(['/business-register']);
      }
    );
  }
}
