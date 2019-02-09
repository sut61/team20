import { Component, OnInit } from '@angular/core';
import {MatSnackBar} from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-store',
  templateUrl: './all-store.component.html',
  styleUrls: ['./all-store.component.css']
})
export class AllStoreComponent implements OnInit {
  stores: Array<Object> = [];
  constructor( private http: HttpClient, private loginService: LoginService, private router: Router,private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.http.get("http://localhost:8080/store").subscribe(
      (data:Array<Object>) => {
        console.log("GET Request is successful ", data);
        this.stores = data;
      },
      error => {
        console.log("Error", error);
        alert("ผิดพลาด " + error)
      }

    );
  }

}
