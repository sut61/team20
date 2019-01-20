import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';
import {HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable, observable } from  "rxjs" ;


@Component({
  selector: 'app-makefood-list',
  templateUrl: './makefood-list.component.html',
  styleUrls: ['./makefood-list.component.css']
})


export class MakefoodListComponent implements OnInit {

  
  Recipes:any={};

  constructor(private loginService:LoginService,private  router :Router,private httpClient: HttpClient) { }

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
    this.httpClient.get('http://localhost:8080/Recipe').subscribe(
        body => {
          this.Recipes = body;
          console.log("GET Request is successful ", body);
        },error => {console.log("Error", error);}
      );    









  }

}
