import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { LoginService } from "../shared/login/login.service";
import { MatSnackBar } from "@angular/material";
import { ReviewfoodService } from "../shared/reviewfood/reviewfood.service";
import { NgForm } from "@angular/forms";
@Component({
  selector: "app-addreviewfood",
  templateUrl: "./addreviewfood.component.html",
  styleUrls: ["./addreviewfood.component.css"]
})
export class AddreviewfoodComponent implements OnInit {
  constructor(
    private loginService: LoginService,
    private snackBar: MatSnackBar,
    private reviewfoodService: ReviewfoodService,
    private router: Router,
    private route: ActivatedRoute
  ) {}
  reviewfood: any = {};
  profiles: any;
  points: Array<any>;
  message = "";
  
  
  
  


  ngOnInit() {
    this.loginService.getUser().subscribe(data => {
      try {
        this.profiles = data;

        console.log(this.profiles.name);
        console.log(this.profiles.email);

        // alert("ยินดีต้อนรับ   คุณ"+this.profiles.name);
      } catch (Err) {
        this.router.navigate(["/login"]);
      }
    });

    this.reviewfoodService.getpointfood().subscribe(data => {
      this.points = data;
      console.log(this.points);
    });

  
      this.clear();
     
    }

  
  
    gotoreviewfood() {
      this.router.navigate(['/reviewfood']);
    }
  
    save(form: NgForm) {
         form.email = this.profiles.email;
         console.log(form)
          this.reviewfoodService.save(form).subscribe(
         data => {
            this.message = JSON.stringify(data);
  
            
            if(this.message==='{"message":"want int"}'){
              this.snackBar.open("กรุณากรอก ราคาเป็นตัวเลข", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }
  
            if(this.message==='{"message":"save success"}'){
            this.snackBar.open("บันทึกเรียบร้อย", "OK", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
              
            this.gotoreviewfood();}


            if(this.message==='{"message":"food name for review not null"}'){
              this.snackBar.open("กรุณากรอก ชื่ออาหาร", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

            if(this.message==='{"message":"food name for review not special string"}'){
              this.snackBar.open("ชื่ออาหาร ห้ามมีอักษรพิเศษ", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }
            
            if(this.message==='{"message":"price Must not Negative"}'){
              this.snackBar.open("ราคาต้องมากกว่าหรือเท่ากับ 0", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

            if(this.message==='{"message":"price not null"}'){
              this.snackBar.open("กรุณากรอก ราคา", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

            if(this.message==='{"message":"food review for review not null"}'){
              this.snackBar.open("กรุณากรอก คำวิพากษ์วิจารณ์อาหาร", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

            if(this.message==='{"message":"point not null"}'){
              this.snackBar.open("กรุณาเลือก คะแนนรีวิวอาหาร", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }


            if(this.message==='{"message":"restuarant not special string"}'){
              this.snackBar.open("ชื่อร้านอาหารห้ามีอักษรพิเศษ", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

            if(this.message==='{"message":"restaurant identit not null"}'){
              this.snackBar.open("กรุณากรอก จุดเด่นร้านอาหาร", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }
            

            if(this.message==='{"message":"restaurant name not null"}'){
              this.snackBar.open("กรุณากรอกชื่อร้านอาหาร", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

  gotoreviewfood() {
    this.router.navigate(["/reviewfood"]);
  }

  save(form: NgForm) {
    // form.email = this.profiles.email;
    console.log(form);
    this.reviewfoodService.save(form).subscribe(
      data => {
        this.message = JSON.stringify(data);

        if (this.message === '{"message":"want int"}') {
          this.snackBar.open("กรุณากรอก ราคาเป็นตัวเลข", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"save success"}') {
          this.snackBar.open("บันทึกเรียบร้อย", "OK", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });

          this.gotoreviewfood();
        }

        if (this.message === '{"message":"food name for review not null"}') {
          this.snackBar.open("กรุณากรอก ชื่ออาหาร", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (
          this.message ===
          '{"message":"food name for review not special string"}'
        ) {
          this.snackBar.open("ชื่ออาหาร ห้ามมีอักษรพิเศษ", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }
            if(this.message==='{"message":"telephone must start with zero"}'){
              this.snackBar.open("โทรศัพท์ต้องมีขั้นต้นด้วย 0และเป็นตัวเลขเท่านั้น", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

            
            if(this.message==='{"message":"restuarant not special string"}'){
              this.snackBar.open("ชื่อร้านอาหารห้ามมีอัการพิเศษ", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

        if (this.message === '{"message":"price Must not Negative"}') {
          this.snackBar.open("ราคาต้องมากกว่าหรือเท่ากับ 0", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"price not null"}') {
          this.snackBar.open("กรุณากรอก ราคา", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"food review for review not null"}') {
          this.snackBar.open("กรุณากรอก คำวิพากษ์วิจารณ์อาหาร", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }
            

            if(this.message==='{"message":"RESTAURANT(IDENTITY)"}'){
              this.snackBar.open("จุดเด่นร้านอาหารห้ามซ้ำ", "ลองใหม่", {
                duration: 10000,
                verticalPosition:"top",
                horizontalPosition: "center"
              
              });
            }

        if (this.message === '{"message":"point not null"}') {
          this.snackBar.open("กรุณาเลือก คะแนนรีวิวอาหาร", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"restuarant not special string"}') {
          this.snackBar.open("ชื่อร้านอาหารห้ามีอักษรพิเศษ", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"restaurant identit not null"}') {
          this.snackBar.open("กรุณากรอก จุดเด่นร้านอาหาร", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"identity not special string"}') {
          this.snackBar.open("จุดเด่นร้านอาหารห้ามีอัการพิเศษ", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"identity not special string"}') {
          this.snackBar.open("จุดเด่นร้านอาหารห้ามมีอัการพิเศษ", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (
          this.message === '{"message":"restaurant telephonenumber not null"}'
        ) {
          this.snackBar.open("กรุณากรอกเบอร์โทรศัพท์", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"telephone size 9-10"}') {
          this.snackBar.open("กรอกเบอร์โทรศัพท์ต้องมีความยาว 9-10", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        if (this.message === '{"message":"telephone must start with zero"}') {
          this.snackBar.open("โทรศัพท์ต้องมีขั้นต้นด้วย 0", "ลองใหม่", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
        }

        console.log(data);
      },
      error => {
        console.log("Error", error);
        //alert('ไม่สามารถบันทึกได้ server ผิดพลาด');
        this.snackBar.open("ไม่สามารถบันทึกได้ server ผิดพลาด", "ลองใหม่", {
          duration: 10000,
          verticalPosition: "top",
          horizontalPosition: "center"
        });
      }
    );
  }

  clear() {
    this.reviewfood.food = "";
    this.reviewfood.price = "";
    this.reviewfood.pointfood = "";
    this.reviewfood.review = "";
    this.reviewfood.restaurant = "";
    this.reviewfood.telephone = "";
    this.reviewfood.identity = "";
  }

  Logout() {
    this.loginService.logout().subscribe(data => {
      this.router.navigate(["/login"]);
      console.log(data);
    });
  }
}
