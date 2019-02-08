import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable, observable } from  "rxjs" ;
import { AngularFireStorage } from '@angular/fire/storage';
import { finalize, subscribeOn, mergeAll, concatAll } from 'rxjs/operators';
import { LoginService } from '../shared/login/login.service';
import { Router } from '@angular/router';


export interface FoodType { 
  idtype: number;
  nametype: string;
}

export interface CookingMethod {
  value: number;
  viewValue: string;
}

export interface MainIngredients {
  value: number;
  viewValue: string;
}


@Injectable()
@Component({
  selector: 'app-makefood-add',
  templateUrl: './makefood-add.component.html',
  styleUrls: ['./makefood-add.component.css']
})


export class MakefoodAddComponent implements OnInit {
 
  foodtypes : FoodType[] = [];
  cookingmethods:CookingMethod[] =[];
  mainingreds:MainIngredients[] = [];

  private foodname : string;
  private foodtypeid :number;
  private cookingmethodid:number;
  private mainingredid:number;
  private urlphoto : string;
  private howto: string;
  private email:string;

  private Recipe:any={};

  uploadPercent: Observable<number>;
  downloadURL: Observable<string>;
  profileUrl: Observable<string | null>;
  url :any = '';
  file: any;

  constructor(private httpClient: HttpClient,private storage: AngularFireStorage,
    private loginService:LoginService,private  router :Router)
    {  const ref = this.storage.ref('test/');
    console.log(ref);}



    addRecipe(){

      const filePath = `test/${new Date().getTime()}_${this.file.name}`;
      const fileRef = this.storage.ref(filePath);
      const task = this.storage.upload(filePath, this.file);
  
      
      
      // observe percentage changes
      this.uploadPercent = task.percentageChanges();
      
      // get notified when the download URL is available
      task.snapshotChanges().pipe(
          finalize(() =>{ this.downloadURL = fileRef.getDownloadURL()
                         this.downloadURL.subscribe(urllink =>{
                           this.urlphoto = urllink;

                           this.addRecipetoDB(this.foodname,this.foodtypeid,this.cookingmethodid,this.mainingredid,this.urlphoto,this.howto,this.email).subscribe(data =>{
                            
                            console.log( "Update Success" , data) ;
                            this.Recipe=data;
                            alert('เพิ่มสูตรอาหารเรียบร้อย');
                            //this.router.navigate(['/makefood-list']);
                            this.router.navigate(['/addNutri',this.Recipe.id]);
                    
                          },
                          error =>{
                            console.log("Fail Success", error);
                            alert('ไม่สามารถแก้ไขได้ server ผิดพลาดหรือไม่มีข้อมูล');
                          })
                        })          
            })
          
       ).subscribe()
     
    
   
  }

  addRecipetoDB(foodname : string, foodtypeid :number,cookingmethodid:number,mainingredid:number,urlphoto:string,howto: string,email:string){
 
  
     return this.httpClient.post('//localhost:8080/Recipe',{
        'cookingMethod':cookingmethodid,
        'foodType':foodtypeid,
        'mainIngred':mainingredid,
        'email':email,
        'UrlPhoto':urlphoto,
        'foodname':foodname,
        'howto':howto
      })

  }

  ngOnInit() {

    //private premission
    this.loginService.getUser().subscribe(
      data=>{
          try{  
           this.email = data.email;
           console.log(this.email)
          }
          catch(Err){
              this.router.navigate(['/login']);
          }      
      }
    ); 
/////////////////////////////////////////////////////////////////////////
    this.httpClient.get("http://localhost:8080/FoodType").subscribe(
      body => {
        console.log("GET Request is successful ", body);
        for (let index = 0; index < body["length"]; index++) {
          this.foodtypes.push({
            idtype: body[index].id,
            nametype: body[index].name
          })
        }
      },error => {console.log("Error", error);}
    );

    this.httpClient.get("http://localhost:8080/CookingMethod").subscribe(
      body => {
        console.log("GET Request is successful ", body);
        for (let index = 0; index < body["length"]; index++) {
          this.cookingmethods.push({
            value: body[index].id,
            viewValue: body[index].name
          })
        }
      },error => {console.log("Error", error);}
    );

    this.httpClient.get("http://localhost:8080/MainIngraed").subscribe(
      body => {
        console.log("GET Request is successful ", body);
        for (let index = 0; index < body["length"]; index++) {
          this.mainingreds.push({
            value: body[index].id,
            viewValue: body[index].name
          })
        }
      },error => {console.log("Error", error);}
    );

  }

  getFile(event) {

    this.file = event.target.files[0];
    console.log(this.file);

    if (event.target.files && event.target.files[0]) {
      const file = event.target.files[0];

      const reader = new FileReader();
      reader.onload = e => this.url = reader.result;

      reader.readAsDataURL(file);
      }
  }
}
 


 


