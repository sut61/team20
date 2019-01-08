import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-manu',
  templateUrl: './manu.component.html',
  styleUrls: ['./manu.component.css']
})
export class ManuComponent implements OnInit {

  profiles : Observable<any>;

  constructor(private loginService:LoginService) { }


  ngOnInit() {
    this.loginService.getUser().subscribe(
      data=>{
            this.profiles=data;
            console.log(this.profiles);
            alert("ยินดีต้อนรับ   คุณ"+this.profiles.name);
            
      }

    );
  }

}
