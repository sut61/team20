import { Component, OnInit } from '@angular/core';
import { Form, NgForm, FormControl, FormGroup } from '@angular/forms';
import { ReportProblemService } from '../shared/reportproblem/report-problem.service';
import { AngularFireStorage } from '@angular/fire/storage';
import { finalize } from 'rxjs/operators';
import { Observable } from 'rxjs';
import * as firebase from 'firebase';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-report-problem',
  templateUrl: './report-problem.component.html',
  styleUrls: ['./report-problem.component.css']
})
export class ReportProblemComponent implements OnInit {
  tags:Array<any>;  rooms:Array<any>; tagIdList:Array<number>;
  report:any;
  uploadPercent: Observable<number>;
  downloadURL: Observable<string>;
  profileUrl: Observable<string | null>;
  imgUrl;
  form;
  file:File;
  email: string;
  constructor(private reportproblemService: ReportProblemService,private storage: AngularFireStorage,
              private loginService:LoginService,private  router :Router) { 
  }
  ngOnInit() {
    this.getTagList();
    this.getRoomList();
    this.loginService.getUser().subscribe(data => {
      try{
            
        this.email = data.email;
        console.log(this.email)

       }
       catch(Err){
           this.router.navigate(['/login']);
       }
    });
  }
  getTagList(){
    this.reportproblemService.getTagList().subscribe(data => {
      this.tags = data;
      console.log('tag :' ,this.tags)
    });
  }
  getRoomList(){
    this.reportproblemService.getRoomList().subscribe(data =>{
      this.rooms = data;
    })
  }
  getReport(){
    this.reportproblemService.getReport().subscribe(data =>{
      this.report = data;
    });
  }


  postReport(newReport){
    this.form = newReport;
    if(newReport.title == null || newReport.detail == null || newReport.roomId == null || this.tagIdList == null || this.file ==null){
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }
    else{
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
  }

  saveData(){
    //save to spring-boot
    this.form.imgUrl = this.imgUrl;
    this.form.email = this.email;
    this.reportproblemService.newReport(this.tagIdList,this.form).subscribe(
      data =>{
        alert('แจ้งปัญหาสำเร็จ');
        console.log(data);
        this.router.navigate(['/show-report-problem']);
     },
     error => {
        alert('error');
        console.log('error: ',error);
     });
  }
  
  selectFile(event){
    this.file = event.target.files[0];
  }

  clear(newReport:NgForm){
    newReport.resetForm();
  }
}
