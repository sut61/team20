import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators, NgForm } from "@angular/forms";
import { GeneratecodeService } from "../shared/generatecode/generatecode.service";
import { Router } from "@angular/router";
import { LoginService } from "../shared/login/login.service";
import { MatSnackBar } from "@angular/material";

@Component({
  selector: "app-generate-serial-code",
  templateUrl: "./generate-serial-code.component.html",
  styleUrls: ["./generate-serial-code.component.css"]
})
export class GenerateSerialCodeComponent implements OnInit {
  options: FormGroup;
  email: string;
  stores: any;

  testDetail = "DETAILXXXXXXXXXXssssssssssssssXXXXXXXX";
  testConditionId = 1;
  testStoreId = 1;

  genForm: any = {
    storeId: "",
    detail: "",
    conditionId: "",
    genCount: ""
  };
  conditions: any;

  constructor(
    private snackBar: MatSnackBar,
    private generateCodeService: GeneratecodeService,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loginService.getUser().subscribe(data => {
      try {
        this.email = data.email;
        console.log(this.email);
        this.getStore();
      } catch (Err) {
        this.router.navigate(["/login"]);
      }
    });
    this.getCondotion();
  }
  getCondotion() {
    this.generateCodeService.getCondition().subscribe(data => {
      this.conditions = data;
    });
  }
  getStore() {
    this.generateCodeService.getStore(this.email).subscribe(data => {
      this.stores = data;
      console.log(data);
    });
  }

  testExpDate() {
    this.generateCodeService
      .testGenerateCode(this.testStoreId, this.testConditionId, this.testDetail)
      .subscribe(
        data => {
          alert("Successful!");
          this.testDetail = "DETAILXXXXXXXXXXssssssssssssssXXXXXXXX";
          this.testConditionId = 1;
        },
        error => {
          alert("ERROR!");
          console.log("ERROR", error);
        }
      );
  }

  generateConfirm(genForm: NgForm) {
    console.log(genForm);
    if (
      this.genForm.storeId === "" ||
      this.genForm.detail === "" ||
      this.genForm.conditionId === "" ||
      this.genForm.genCount === "" ||
      this.genForm.genCount === 0
    ) {
      this.snackBar.open("กรุณากรอกข้อมูลให้ครบถ้วน ", "ตกลง", {
        duration: 10000,
        verticalPosition: "top",
        horizontalPosition: "center"
      });
    } else if (this.genForm.genCount > 20) {
      this.snackBar.open("กรอกจำนวนที่ต้องการสร้างรหัสมากเกินไป ", "ตกลง", {
        duration: 10000,
        verticalPosition: "top",
        horizontalPosition: "center"
      });
    } else {
      this.generateCodeService.generateSerialCode(genForm).subscribe(
        data => {
          this.snackBar.open("ดำเนินการเสร็จสิ้น ", "ตกลง", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
          console.log("Successful!");
          this.genForm.storeId = "";
          this.genForm.detail = "";
          this.genForm.conditionId = "";
          this.genForm.genCount = "";
          this.router.navigate(["/manu"]);
        },
        error => {
          this.snackBar.open("ไม่สามารถดำเนินการได้ ", "ตกลง", {
            duration: 10000,
            verticalPosition: "top",
            horizontalPosition: "center"
          });
          console.log("Error Cannot generate serial code!", error);
        }
      );
    }
  }

  numberOnly(event): boolean {
    const charCode = event.which ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;
  }
}
