import { Component, OnInit } from '@angular/core';
import { OrderService } from '../shared/order/order.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-food',
  templateUrl: './order-food.component.html',
  styleUrls: ['./order-food.component.css']
})
export class OrderFoodComponent implements OnInit {

  storeId;
  sendFoodId;
  foods: Array<any>;
  constructor(private orderService: OrderService, private  router :Router) {
    
  }

  ngOnInit() {
    this.storeId = localStorage.getItem("store");
    console.log(this.storeId);
    this.getOrderFoodListById();
  }

  getOrderFoodListById() {
    this.orderService.getOrderFoodListById(this.storeId).subscribe(data => {
      this.foods = data;
      console.log(data);
    });
  }

  sendFoodDetail(foodid) {
    localStorage.setItem("food", foodid);
    this.router.navigate(['/order/confirm']);
    console.log(foodid);
  }

  clear() {
    localStorage.clear();
  }
}
