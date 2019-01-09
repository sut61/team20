import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-makefood-list',
  templateUrl: './makefood-list.component.html',
  styleUrls: ['./makefood-list.component.css']
})
export class MakefoodListComponent implements OnInit {

  constructor(private loginService:LoginService,private  router :Router) { }

  ngOnInit() {
    this.loginService.getUser().subscribe(
      data=>{
          try{
            
           
           console.log(data.name)
          }
          catch(Err){
              this.router.navigate(['/login']);
          }
            
      }
      

    );
  }

}
