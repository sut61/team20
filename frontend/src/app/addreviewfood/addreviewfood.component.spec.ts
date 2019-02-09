import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddreviewfoodComponent } from './addreviewfood.component';

describe('AddreviewfoodComponent', () => {
  let component: AddreviewfoodComponent;
  let fixture: ComponentFixture<AddreviewfoodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddreviewfoodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddreviewfoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
