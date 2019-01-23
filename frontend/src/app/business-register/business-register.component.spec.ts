import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessRegisterComponent } from './business-register.component';

describe('BusinessRegisterComponent', () => {
  let component: BusinessRegisterComponent;
  let fixture: ComponentFixture<BusinessRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BusinessRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
