import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNutriComponent } from './add-nutri.component';

describe('AddNutriComponent', () => {
  let component: AddNutriComponent;
  let fixture: ComponentFixture<AddNutriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNutriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNutriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
