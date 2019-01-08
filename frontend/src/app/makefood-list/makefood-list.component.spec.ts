import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakefoodListComponent } from './makefood-list.component';

describe('MakefoodListComponent', () => {
  let component: MakefoodListComponent;
  let fixture: ComponentFixture<MakefoodListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakefoodListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakefoodListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
