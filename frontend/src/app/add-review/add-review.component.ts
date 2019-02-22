import { Component, OnInit, ElementRef, ViewChild, Renderer2 } from '@angular/core';
import {MatSnackBar} from '@angular/material';
import { Observable } from 'rxjs';
import { AngularFireStorage } from '@angular/fire/storage';
import { finalize } from 'rxjs/operators';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from "@angular/router";
import { store } from '@angular/core/src/render3';

@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {
  uploadPercent: Observable<number>;
  ObservableURL: Observable<string>;
  profileUrl: Observable<string | null>;
  files: any = [];
  dowloadURL: Array<string> = [];
  formData: any;
  nImage: Array<number> = [0]
  store:object = {id:0, image:"", numberOfSeat:{choices:""}, priceRange:{range:""}};
  rating : any;
  pricePerHead : any;
  load:boolean = false;
  id = this.route.snapshot.paramMap.get("id")
  userEmail: string;


  constructor(private route: ActivatedRoute,private storage: AngularFireStorage, private http: HttpClient, private loginService: LoginService, private router: Router,private snackBar: MatSnackBar) { }

  ngOnInit() {

    this.loginService.getUser().subscribe(data => {
      try{
            
        this.userEmail = data.email;
        console.log(this.userEmail)

       }
       catch(Err){
           this.router.navigate(['/login']);
       }
    });

    this.http.get("http://localhost:8080/store/"+this.id).subscribe(
      data => {
        console.log("GET Request is successful ", data);
        this.store = data;
      },
      error => {
        console.log("Error", error);
        //alert("ผิดพลาด " + error)
      }

    );

    this.http.get("http://localhost:8080/review/pricePerHead").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        this.pricePerHead = data;
      },
      error => {
        console.log("Error", error);
        //alert("ผิดพลาด " + error)
      }

    );

    this.http.get("http://localhost:8080/review/rating").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        this.rating = data;
      },
      error => {
        console.log("Error", error);
        //alert("ผิดพลาด " + error)
      }

    );
  }

  getFile(event) {

    this.files.push(
      event.target.files[0]
    );
    console.log(this.files);
  }

  onSubmit(data) {
    this.load = true;
    this.formData = data;
    console.log(this.formData);

    this.files.forEach((file, key) => {
      console.log(file, key);
      
       const filePath = `test/${new Date().getTime()}_${file.name}`;
      const fileRef = this.storage.ref(filePath);
      const task = this.storage.upload(filePath, file);

      // observe percentage changes
      this.uploadPercent = task.percentageChanges();
      // get notified when the download URL is available
      task.snapshotChanges().pipe(
        finalize(() => {
          this.ObservableURL = fileRef.getDownloadURL()
          this.ObservableURL.subscribe(val => {
            this.dowloadURL.push(val)
            
            

            if(this.dowloadURL.length == this.files.length)
              this.saveData();
            else
              console.log(this.dowloadURL);
              
              
          })
        })
      ).subscribe() 

    });
  }

  saveData() {
    this.formData.image = this.dowloadURL;
    this.formData.email = this.userEmail;
    this.formData.store = this.id;
    console.log(this.formData);

    this.http.post("http://localhost:8080/review", this.formData).subscribe(
      data => {
        console.log("POST Request is successful ", data);
        this.load = false;
        this.snackBar.open("ขอบคุณสำหรับการรีวิว","Undo", {
          duration: 10000,
          verticalPosition:"bottom",
          horizontalPosition: "center"
        
        });
        this.router.navigate(['/show-store/'+this.id]);
      },
      error => {
        console.log("Error", error);
        this.load = false;
        alert("ไม่สามารถบันทึกได้")
      }

    );

  }

  addImage() {
    this.nImage.push(
      this.nImage.length
    )
  }

}
