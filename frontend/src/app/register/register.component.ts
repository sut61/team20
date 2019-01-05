import { Component, OnInit } from '@angular/core';
import { RegisterService} from '../shared/register/register.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message ="";
  register : any =  {};
  constructor(private registerservice: RegisterService) { }
  prefixs: Array<any>;
  sexs: Array<any>;
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
    this.registerservice.save(form).catch((err: HttpErrorResponse) => {
      // simple logging, but you can do a lot more, see below
      Windows.alert(err.error);
    });
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
