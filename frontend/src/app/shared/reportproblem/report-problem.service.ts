import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { NgForm } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ReportProblemService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  private messageSource = new BehaviorSubject(JSON);
  currentMessage = this.messageSource.asObservable();

  getTagList(): Observable<any> {
    return this.http.get(this.API + '/Tag');
  }

  getRoomList(): Observable<any> {
    return this.http.get(this.API + '/Room');
  }

  newReport(tagId:Array<number>,newReport:NgForm){
    return this.http.post(this.API + '/ReportProblem/'+tagId+'/',newReport);
  }

  newReport2(imgUrl:string,tagId:Array<number>,newReport:NgForm){
    return this.http.post(this.API + '/ReportProblem/'+imgUrl+'/'+tagId+'/',newReport);
  }

  getReport(){
    return this.http.get(this.API + '/ReportProblem');
  }

  changeMessage(message) {
    this.messageSource.next(message)
  }
}
