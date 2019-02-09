import { Component, OnInit } from '@angular/core';
import { AdvertiseService } from '../shared/advertise/advertise.service';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { finalize } from 'rxjs/operators';
import { AngularFireStorage } from '@angular/fire/storage';
import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-shop-advertise',
  templateUrl: './shop-advertise.component.html',
  styleUrls: ['./shop-advertise.component.css']
})
export class ShopAdvertiseComponent implements OnInit {
  packages: any;
  email: string;
  stores: any;
  file: any;
  advertises: any;
  uploadPercent: Observable<number>;
  downloadURL: Observable<string>;
  profileUrl: Observable<string | null>;
  imgUrl;
  form;
  constructor(private snackBar: MatSnackBar, private advertiseService: AdvertiseService,
    private loginService: LoginService, private router: Router, private storage: AngularFireStorage) { }

  ngOnInit() {
    this.loginService.getUser().subscribe(data => {
      try {
        this.email = data.email;
        console.log(this.email)
        this.getStore();
      }
      catch (Err) {
        this.router.navigate(['/login']);
      }
    });
    this.getAdvertisePackage();
    this.getShopAdvertise();
  }

  getAdvertisePackage() {
    this.advertiseService.getAdvertisePackage().subscribe(data => {
      this.packages = data;
    });
  }

  getStore() {
    this.advertiseService.getStore(this.email).subscribe(data => {
      this.stores = data;
      console.log(data);
    });
  }

  getShopAdvertise() {
    this.advertiseService.getShopAdvertise().subscribe(data => {
      this.advertises = data;
    })
  }

  checkStore(store) {
    //แสดงเฉพาะstoreที่ยังไม่เคยสมัคร
    for (let i = 0; i < this.advertises["length"]; i++) {
      if (this.advertises[i].store.id === store.id) {
        return false;
      }
    }
    return true;
  }

  selectFile(event) {
    this.file = event.target.files[0];
  }

  clear(myform: NgForm) {
    myform.resetForm();
  }

  register(myform) {
    this.form = myform;
    //upload to firebase
    const filePath = `test/${new Date().getTime()}_${this.file.name}`;
    const fileRef = this.storage.ref(filePath);
    const task = this.storage.upload(filePath, this.file);

    // observe percentage changes
    this.uploadPercent = task.percentageChanges();
    // get notified when the download URL is available
    task.snapshotChanges().pipe(
      finalize(() => {
        this.downloadURL = fileRef.getDownloadURL()
        this.downloadURL.subscribe(val => {
          this.imgUrl = val;
          console.log(this.imgUrl);
          this.saveData();
        })
      })
    ).subscribe()
  }

  saveData() {
    this.form.imgUrl = this.imgUrl;
    this.form.email = this.email;
    this.advertiseService.registerAdvertise(this.form).subscribe(
      data => {
        this.snackBar.open("สมัครสำเร็จ ", 'ตกลง', {
          duration: 10000,
          verticalPosition: "top",
          horizontalPosition: "center"
        });
        console.log(data);
        this.router.navigate(['/manu']);
      },
      error => {
        console.log(error);
        this.snackBar.open("สมัครไม่สำเร็จ ", 'ตกลง', {
          duration: 10000,
          verticalPosition: "top",
          horizontalPosition: "center"
        });
      });
  }
}
