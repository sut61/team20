import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakefoodDetailComponent } from './makefood-detail.component';

describe('MakefoodDetailComponent', () => {
  let component: MakefoodDetailComponent;
  let fixture: ComponentFixture<MakefoodDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakefoodDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakefoodDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
