import { Component, OnInit } from '@angular/core';
import { RegisterService} from '../shared/register/register.service';
import { NgForm } from '@angular/forms';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { ActivatedRoute, Router } from '@angular/router';
import {MatSnackBar} from '@angular/material';




@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {



  register : any =  {};


  constructor(private snackBar: MatSnackBar,private registerservice: RegisterService,private router : Router,private route: ActivatedRoute) { }
  prefixs: Array<any>;
  sexs: Array<any>;
   message ="";
  ngOnInit() {
    this.registerservice.getprefix().subscribe(data => {
      this.prefixs = data;
      console.log(this.prefixs);
    });

    this.registerservice.getsex().subscribe(data => {
      this.sexs = data;
      console.log(this.sexs);
    });
    this.clear();
   
  }

  gotoManu() {
    this.router.navigate(['/login']);
  }

  save(form: NgForm) {
    if(this.register.email === ''||
    this.register.password === ''||
    this.register.prefix === ''||
    this.register.name === ''||
    this.register.telephonenumber === ''||
    this.register.sex === ''||
    this.register.address === ''){

      //alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      this.snackBar.open("กรุณากรอกข้อมูลให้ครบถ้วน ", "ลองใหม่", {
        duration: 10000,
        verticalPosition:"top",
        horizontalPosition: "center"
      
      });
      

    }
    else{
        this.registerservice.save(form).subscribe(
      data => {
          this.message = JSON.stringify(data);

          if(this.message==='{"message":"กรอกemailไม่ถูกต้อง"}'){
            this.snackBar.open("กรุณากรอก email ให้ถูกต้อง ", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"กรุณาเลือกคำนำหน้า"}'){
            this.snackBar.open("กรุณา เลือกคำนำหน้า", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"กรุณาเลือกเพศ"}'){
            this.snackBar.open("กรุณา เลือกเพศ", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }


          if(this.message==='{"message":"กรุณากรอกที่อยู่"}'){
            this.snackBar.open("กรุณา กรอกที่อยู่", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"ที่อยู่ต้องอย่างน้อย 20 อักษร"}'){
            this.snackBar.open("กรุณา กรอกที่อยู่ต้องอย่างน้อย 20 อักษร", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"กรุณากรอกเบอร์โทรศัพท์"}'){
            this.snackBar.open("กรุณา กรอกเบอร์โทรศัพท์", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"เบอร์โทรศัพท์ต้องขึ้นต้นด้วย 0 และตัวเลขครบ 10 ตัว"}'){
            this.snackBar.open("กรุณา กรอกเบอร์โทรศัพท์ต้องขึ้นต้นด้วย 0 และตัวเลขครบ 10 ตัว", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }
         

          if(this.message==='{"message":"CONTACT(TELEPHONENUMBER)"}'){
            this.snackBar.open("กรุณา กรอกเบอร์โทรศัพท์ใหม่หมายเลขนี้ลงทะเบียนแล้ว", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"PROFILES(EMAIL)"}'){
            this.snackBar.open("กรุณา กรอกEmailใหม่Emailนี้ลงทะเบียนแล้ว", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"กรุณากรอกรหัสผ่าน"}'){
            this.snackBar.open("กรุณา กรอกรหัสผ่าน", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"รหัสผ่านอย่างน้อย8อักษร"}'){
            this.snackBar.open("กรุณา รหัสผ่านอย่างน้อย8อักษร", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"message":"รหัสผ่านอย่างน้อย8อักษร"}'){
            this.snackBar.open("กรุณา รหัสผ่านอย่างน้อย8อักษร", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          if(this.message==='{"กรุณากรอกชื่อและนามสกุล"}'){
            this.snackBar.open("กรุณา กรอกชื่อและนามสกุล", "ลองใหม่", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          }

          
        
          if(this.message==='{"message":"บันทึกเรียบร้อย"}'){
            
            this.snackBar.open("บันทึกเรียบร้อย", "OK", {
              duration: 10000,
              verticalPosition:"top",
              horizontalPosition: "center"
            
            });
          this.gotoManu();}


      console.log(data);
      },
      error => {
          console.log('Error', error);
          //alert('ไม่สามารถบันทึกได้ server ผิดพลาด');
          this.snackBar.open("ไม่สามารถบันทึกได้ server ผิดพลาด", "ลองใหม่", {
            duration: 10000,
            verticalPosition:"top",
            horizontalPosition: "center"
          
          });
      }

      );
    }

  }

  clear(){
      this.register.email = "";
      this.register.password = "";
      this.register.prefix = "";
      this.register.name = "";
      this.register.telephonenumber = "";
      this.register.sex = "";
      this.register.address = "";

  }

}
