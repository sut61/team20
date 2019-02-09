import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-show-store',
  templateUrl: './show-store.component.html',
  styleUrls: ['./show-store.component.css']
})
export class ShowStoreComponent implements OnInit {
  id = this.route.snapshot.paramMap.get("id");
  store: object = {image:"", numberOfSeat:{choices:""}, priceRange:{range:""},pricePerHead:{pricePerHead:""}, rating:{rating:""}};
  reviews: Array<object> = [{profile:{name:"",email:""}}]

  constructor(private route: ActivatedRoute, private http: HttpClient, private router: Router,private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.http.get("http://localhost:8080/store/"+this.id).subscribe(
      data => {
        console.log("GET Request is successful ", data);
        this.store = data;
      },
      error => {
        console.log("Error", error);
        alert("ผิดพลาด " + error)
      }

    );
    this.http.get("http://localhost:8080/review/"+this.id).subscribe(
      (data:Array<object>) => {
        console.log("GET Request is successful ", data);
        this.reviews = data;
      },
      error => {
        console.log("Error", error);
        alert("ผิดพลาด " + error)
      }

    );
  }

}
