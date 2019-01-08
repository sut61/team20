import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';

@Component({
  selector: 'app-manu',
  templateUrl: './manu.component.html',
  styleUrls: ['./manu.component.css']
})
export class ManuComponent implements OnInit {

  name : Array<any>;

  constructor(private loginService:LoginService) { }

  ngOnInit() {
     this.name = this.loginService.getName()
  }

}
