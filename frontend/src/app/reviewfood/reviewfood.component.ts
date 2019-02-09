import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login/login.service';
import { AddreviewfoodComponent } from '../addreviewfood/addreviewfood.component';
import { ReviewfoodService } from '../shared/reviewfood/reviewfood.service';

@Component({
  selector: 'app-reviewfood',
  templateUrl: './reviewfood.component.html',
  styleUrls: ['./reviewfood.component.css']
})
export class ReviewfoodComponent implements OnInit {
  
  constructor(private reviewService: ReviewfoodService,private loginService: LoginService, private router: Router) { }

  profiles: any;
  foods:any={};
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

    this.reviewService.getAllfood().subscribe(data => {
      this.foods = data;
      console.log(this.foods);
    });




  }
  Logout() {



    this.loginService.logout().subscribe(
      data => {

        this.router.navigate(['/login']);
        console.log(data);

      }
    );

  }


  }

