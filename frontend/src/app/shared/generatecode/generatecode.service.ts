import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { BehaviorSubject } from "rxjs";
import { Form } from "@angular/forms";

@Injectable({
  providedIn: "root"
})
export class GeneratecodeService {
  public API = "//localhost:8080";

  constructor(private http: HttpClient) {}

  testGenerateCode(storeId: number, conditionId: number, detail: string) {
    return this.http.post(
      this.API +
        "/SerialCodes/generate/" +
        storeId +
        "/" +
        conditionId +
        "/" +
        detail,
      {
        conditionId: conditionId,
        detail: detail
      }
    );
  }

  generateSerialCode(genForm: Form): Observable<any> {
    return this.http.post(this.API + "/SerialCodes/generate/", genForm);
  }

  getCondition(): Observable<any> {
    return this.http.get(this.API + "/SerialCodeCondition");
  }

  getStore(email: string): Observable<any> {
    return this.http.get(this.API + "/SerialCodeGetStore/" + email);
  }
}
