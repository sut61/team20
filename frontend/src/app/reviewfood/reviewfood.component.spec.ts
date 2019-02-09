import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewfoodComponent } from './reviewfood.component';

describe('ReviewfoodComponent', () => {
  let component: ReviewfoodComponent;
  let fixture: ComponentFixture<ReviewfoodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReviewfoodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewfoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
