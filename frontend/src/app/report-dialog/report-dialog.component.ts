import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { Subscription } from 'rxjs';
import { ReportProblemService } from '../shared/reportproblem/report-problem.service';

@Component({
  selector: 'app-report-dialog',
  templateUrl: './report-dialog.component.html',
  styleUrls: ['./report-dialog.component.css']
})
export class ReportDialogComponent implements OnInit {

  message: any;
  subscription: Subscription;

  constructor(public dialogRef: MatDialogRef<ReportDialogComponent>,private reportproblemService: ReportProblemService) { 
    
  }
  
  ngOnInit() {
    this.reportproblemService.currentMessage.subscribe(message => this.message = message)
    console.log(this.message);
  }

  onClose() {
    this.dialogRef.close();
  }

}
