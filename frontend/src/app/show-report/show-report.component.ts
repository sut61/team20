import { Component, OnInit, ViewChild } from '@angular/core';
import { ReportProblemService } from '../shared/reportproblem/report-problem.service';
import { MatTableDataSource, MatPaginator, MatDialogConfig, MatDialog } from '@angular/material';
import { ReportDialogComponent } from '../report-dialog/report-dialog.component';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';
export interface Report {  
  id:number
  title:string;
  detail:string;
  room:string;
  imgUrl:string;
  tag:any;
  userName:string;
}

@Component({
  selector: 'app-show-report',
  templateUrl: './show-report.component.html',
  styleUrls: ['./show-report.component.css']
})
export class ShowReportComponent implements OnInit {

  email;
  reports:any;
  dataSource:any;
  displayedColumns: string[] = ['reportId', 'title', 'detail','room','tag','actions'];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  message: string;
  
  constructor(private reportproblemService: ReportProblemService,private dialog: MatDialog,
              private loginService:LoginService,private  router :Router) { }

  ngOnInit() {
    this.getReport();
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
  getReport(){
    this.reportproblemService.getReport().subscribe(data => {
      this.reports = data;
      const reportList: Report[] = [];
      console.log(this.reports);
      for (let index = 0; index < this.reports["length"]; index++) {
        let tagTemp = new Array<String>();
        for(let j = 0 ;j < this.reports[index].tags["length"];j++){
          tagTemp[j] = this.reports[index].tags[j].name;
        }
        reportList.push({
          id: this.reports[index].id,
          title: this.reports[index].title,
          detail: this.reports[index].detail,
          imgUrl: this.reports[index].imgUrl,
          room: this.reports[index].room.name,
          tag: tagTemp,
          userName: this.reports[index].user.name,
        })
        }  
        this.dataSource = new MatTableDataSource(reportList);
        this.dataSource.paginator = this.paginator;
    });
  }
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onView(row){
    // send message to subscribers via observable subject
    this.reportproblemService.changeMessage(row);
    this.reportproblemService.currentMessage.subscribe();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "30%";
    this.dialog.open(ReportDialogComponent,dialogConfig);
  }

}
