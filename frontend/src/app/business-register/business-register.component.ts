import { Component, OnInit } from '@angular/core';
import { BusinessService } from '../shared/ิbusiness/business.service';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-business-register',
  templateUrl: './business-register.component.html',
  styleUrls: ['./business-register.component.css']
})
export class BusinessRegisterComponent implements OnInit {

  types;
  provinces;
  form;
  userEmail: string;
  constructor(private businessService:BusinessService,private loginService:LoginService,private  router :Router) { }

  ngOnInit() {
    this.loginService.getUser().subscribe(data => {
      try{
            
        this.userEmail = data.email;
        console.log(this.userEmail)

       }
       catch(Err){
           this.router.navigate(['/login']);
       }
    });

    this.businessService.getProvince().subscribe(data => {
      this.provinces = data;
    });

    this.businessService.getBusinessType().subscribe(data => {
      this.types = data;
    });

  }

  save(myform){
    this.form = myform;
    this.form.userEmail = this.userEmail;
    console.log(this.form);
    this.businessService.postBusiness(myform).subscribe(data => {
      console.log(data);
    },
    error =>{
      alert('สมัครไม่สำเร็จ');
      console.log(error);
    });
  }

}
