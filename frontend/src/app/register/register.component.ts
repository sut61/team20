import { Component, OnInit } from '@angular/core';
import { RegisterService} from '../shared/register/register.service';


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
