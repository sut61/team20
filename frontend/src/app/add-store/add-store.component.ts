import { Component, OnInit } from '@angular/core';
import { AngularFireStorage } from '@angular/fire/storage';
import { finalize } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';
import { BusinessService } from '../shared/ิbusiness/business.service';

@Component({
  selector: 'app-add-store',
  templateUrl: './add-store.component.html',
  styleUrls: ['./add-store.component.css']
})
export class AddStoreComponent implements OnInit {
  uploadPercent: Observable<number>;
  ObservableURL: Observable<string>;
  profileUrl: Observable<string | null>;
  file: any;
  dowloadURL: string;
  formData: any;
  dayOfWeeks = [
    { value: 'จันทร์', viewValue: 'จันทร์' },
    { value: 'อังคาร', viewValue: 'อังคาร' },
    { value: 'พุธ', viewValue: 'พุธ' },
    { value: 'พฤหัสบดี', viewValue: 'พฤหัสบดี' },
    { value: 'ศุกร์', viewValue: 'ศุกร์' },
    { value: 'เสาร์', viewValue: 'เสาร์' },
    { value: 'อาทิตย์', viewValue: 'อาทิตย์' },
  ];

  priceRanges = [];
  numberOfSeat = [];


  times = []
  email: string;
  profiles: any;

  constructor(private storage: AngularFireStorage, private http: HttpClient, private loginService: LoginService, private businessService: BusinessService, private router: Router) { }

  ngOnInit() {
    this.loginService.getUser().subscribe(data => {
      try {

        this.email = data.email;
        console.log(this.email)

      }
      catch (Err) {
        this.router.navigate(['/login']);
      }
    });
    for (let index = 0; index < 24; index++) {
      this.times.push(
        { value: index + ':00', viewValue: index + ':00' },
      );
    }

    this.http.get("http://localhost:8080/store/pricerange").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.priceRanges.push({
            value: data[index].id+'',
            viewValue: data[index].range
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );

    this.http.get("http://localhost:8080/store/numberofseat").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.numberOfSeat.push({
            value: data[index].id+'',
            viewValue: data[index].choices
          })
        }
      },
      error => {
        console.log("Error", error);
      }
    );
  }
  removable = true;

  time: any = [];

  addTimeservice(data) {
    console.log(data);

    if (data.dayOfWeek == "" || data.timeOpen == "" || data.timeClose == "")
      console.log("ว่าง")
    else if (parseFloat(data.timeClose.replace(":", ".")) <= parseFloat(data.timeOpen.replace(":", "."))
    ) {
      console.log("เวลาไม่ถูกต้อง")
    }
    else if (
      this.time.find(
        (cur) => {
          return data.dayOfWeek + " " + data.timeOpen + " - " + data.timeClose == cur;
        }
      ) == undefined
    ) {
      this.time.push(
        data.dayOfWeek + " " + data.timeOpen + " - " + data.timeClose
      )
    }
    else
      console.log("ซ้ำ")


  }

  getFile(event) {

    this.file = event.target.files[0];
    console.log(this.file);
  }

  onSubmit(data) {
    this.formData = data;

    const filePath = `test/${new Date().getTime()}_${this.file.name}`;
    const fileRef = this.storage.ref(filePath);
    const task = this.storage.upload(filePath, this.file);

    // observe percentage changes
    this.uploadPercent = task.percentageChanges();
    // get notified when the download URL is available
    task.snapshotChanges().pipe(
      finalize(() => {
        this.ObservableURL = fileRef.getDownloadURL()
        this.ObservableURL.subscribe(val => {
          this.dowloadURL = val;
          console.log(this.dowloadURL);

          this.saveData();
        })
      })
    ).subscribe()
  }


  saveData() {
    this.formData.email = this.email;

    this.formData.time = JSON.stringify(this.formData.time)
    this.formData.image = this.dowloadURL;
    console.log(this.formData);

    this.http.post("http://localhost:8080/store", this.formData).subscribe(
      data => {
        console.log("POST Request is successful ", data);
        alert("สำเร็จ")
        this.router.navigate(['/manu']);
      },
      error => {
        console.log("Error", error);
        alert("ผิดพลาด " + error)
      }

    );
  }
}
