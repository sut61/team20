import { Component, OnInit } from '@angular/core';
import { OrderService } from '../shared/order/order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-res',
  templateUrl: './order-res.component.html',
  styleUrls: ['./order-res.component.css']
})

export class OrderResComponent implements OnInit {

  stores: Array<any>;

  constructor(private orderService: OrderService, private  router :Router) {
    
   }
  
  ngOnInit() {
    this.getStoreList();
    console.log(this.stores);
  }

  getStoreList() {
    this.orderService.getStoreList().subscribe(data => {
      this.stores = data;
      console.log(data);
    });
  }

  sendStore(sid) {
    localStorage.setItem("store", sid);
    this.router.navigate(['/order/food']);
    console.log(sid);
  }

  clear() {
    localStorage.clear();
  }
}
