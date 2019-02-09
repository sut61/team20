import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//Angular Material Components
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCheckboxModule} from '@angular/material';
import {MatButtonModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatMenuModule} from '@angular/material/menu';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatBadgeModule} from '@angular/material/badge';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MakefoodListComponent } from './makefood-list/makefood-list.component';
import { MakefoodAddComponent } from './makefood-add/makefood-add.component';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { environment } from '../environments/environment';
import { AngularFireStorageModule,StorageBucket } from '@angular/fire/storage';
import { AngularFireModule } from '@angular/fire';

import { ManuComponent } from './manu/manu.component';
import { LoginService} from './shared/login/login.service';
import { RegisterService} from './shared/register/register.service';
import { OrderService } from './shared/order/order.service';
import { MakefoodDetailComponent } from './makefood-detail/makefood-detail.component';
import { AddStoreComponent } from './add-store/add-store.component';
import { ReportProblemComponent } from './report-problem/report-problem.component';
import { ShowReportComponent } from './show-report/show-report.component';
import { ReportDialogComponent } from './report-dialog/report-dialog.component';
import { BusinessRegisterComponent } from './business-register/business-register.component';
import { OrderResComponent } from './order-res/order-res.component';
import { OrderFoodComponent } from './order-food/order-food.component';
import { OrderConfirmComponent } from './order-confirm/order-confirm.component';
import { PromotionComponent } from './promotion/promotion.component';
import { AddNutriComponent } from './add-nutri/add-nutri.component';
import { ShopAdvertiseComponent } from './shop-advertise/shop-advertise.component';
import { GenerateSerialCodeComponent } from './generate-serial-code/generate-serial-code.component';
import { ReviewfoodComponent } from './reviewfood/reviewfood.component';
import { AddreviewfoodComponent } from './addreviewfood/addreviewfood.component';
import { ReviewfoodService } from './shared/reviewfood/reviewfood.service';





@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    RegisterComponent,
    ManuComponent,
    MakefoodAddComponent,
    MakefoodListComponent,
    MakefoodDetailComponent,
    AddStoreComponent,
    ReportProblemComponent,
    ShowReportComponent,
    ReportDialogComponent,
    BusinessRegisterComponent,
    OrderResComponent,
    OrderFoodComponent,
    OrderConfirmComponent,
    PromotionComponent,
    AddNutriComponent,
    ShopAdvertiseComponent,
    GenerateSerialCodeComponent,
    ReviewfoodComponent,
    AddreviewfoodComponent
  ],


  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatBadgeModule,

    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireStorageModule
    
  ],

  providers: [RegisterService,LoginService, OrderService,ReviewfoodService,{ provide: StorageBucket, useValue: 'gs://uppictest.appspot.com/' },],
  bootstrap: [AppComponent],
  entryComponents:[ReportDialogComponent]
})
export class AppModule { }
