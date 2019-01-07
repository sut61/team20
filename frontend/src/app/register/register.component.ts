import { Component, OnInit } from '@angular/core';
import { RegisterService} from '../shared/register/register.service';
import { NgForm } from '@angular/forms';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {



  register : any =  {};


  constructor(private registerservice: RegisterService,private router : Router,private route: ActivatedRoute) { }
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

      alert('กรุณากรอกข้อมูลให้ครบถ้วน');

    }
    else{
        this.registerservice.save(form).subscribe(
      data => {
          this.message = JSON.stringify(data);

          if(this.message==='{"message":"emailนี้ ลงทะเบียนไปแล้ว กรุณาใช้ email อื่น"}'){alert('emailนี้ ลงทะเบียนไปแล้ว กรุณาใช้ email อื่น');}
          if(this.message==='{"message":"เบอร์โทรศัพท์นี้ ลงทะเบียนไปแล้ว กรุณาใช้ เบอร์โทรศัพท์อื่น"}'){alert('เบอร์โทรศัพท์นี้ ลงทะเบียนไปแล้ว กรุณาใช้ เบอร์โทรศัพท์อื่น');}
          if(this.message==='{"message":"ไม่มีเพศในฐานข้อมูล"}'){alert('ไม่มีเพศในฐานข้อมูล');}


          if(this.message==='{"message":"ไม่มีคำนำหน้าในฐานข้อมูล"}'){alert('ไม่มีคำนำหน้าในฐานข้อมูล');}
          if(this.message==='{"message":"เบอร์โทรศัพท์ตัวแรกต้องมีเป็นตัวเลขหรือ + เท่านั้น"}'){alert('เบอร์โทรศัพท์ตัวแรกต้องมีเป็นตัวเลขหรือ + เท่านั้น');}
          if(this.message==='{"message":"เบอร์โทรศัพท์ต้องเป็นตัวเลขเท่านั้น และตัวแรกสามารถเป็น + ได้"}'){alert('เบอร์โทรศัพท์ต้องเป็นตัวเลขเท่านั้น และตัวแรกสามารถเป็น + ได้');}
          if(this.message==='{"message":"เบอร์โทรศัพท์ต้องมีความยาว 9 -12 ตัวอักษร"}'){alert('เบอร์โทรศัพท์ต้องมีความยาว 9 -12 ตัวอักษร');}

          if(this.message==='{"message":"รหัสผ่านต้องมีความยาว ไม่น้อยกว่า 8 อักษร"}'){alert('รหัสผ่านต้องมีความยาว ไม่น้อยกว่า 8 อักษร');}
          if(this.message==='{"message":"ที่อยู่ต้องมีความยาว ไม่น้อยกว่า 20 อักษร"}'){alert('ที่อยู่ต้องมีความยาว ไม่น้อยกว่า 20 อักษร');}
          if(this.message==='{"message":"ที่อยู่ต้องไม่มีอักษรพิเศษ"}'){alert('ที่อยู่ต้องไม่มีอักษรพิเศษ');}
          if(this.message==='{"message":"ชื่อและนามสกุลต้องไม่มีอักษรพิเศษ"}'){alert('ชื่อและนามสกุลต้องไม่มีอักษรพิเศษ');}

          if(this.message==='{"message":"email ต้องลงท้ายด้วย .com หรือ .COM"}'){alert('email ต้องลงท้ายด้วย .com หรือ .COM');}
          if(this.message==='{"message":"email ต้องมี @ 1 อักษร"}'){alert('email ต้องมี @ 1 อักษร');}
          if(this.message==='{"message":"บันทึกเรียบร้อย"}'){alert('บันทึกเรียบร้อย'); this.gotoManu();}




      console.log(data);
      },
      error => {
          console.log('Error', error);
          alert('ไม่สามารถบันทึกได้ server ผิดพลาด');
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
