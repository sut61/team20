import { Component, OnInit } from '@angular/core';
import { RegisterService} from '../shared/register/register.service';
import { NgForm } from '@angular/forms';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

 
  register : any =  {};
  constructor(private registerservice: RegisterService) { }
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
  }

  save(form: NgForm) {
    this.registerservice.save(form).subscribe(
      data => {
          this.message = JSON.stringify(data);
          
          alert(this.message);
          

      console.log(data);
      },
      error => {
          console.log('Error', error);
          alert('ไม่สามารถบันทึกได้ server ผิดพลาด');
      }
  );
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
