import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopAdvertiseComponent } from './shop-advertise.component';

describe('ShopAdvertiseComponent', () => {
  let component: ShopAdvertiseComponent;
  let fixture: ComponentFixture<ShopAdvertiseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopAdvertiseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopAdvertiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
