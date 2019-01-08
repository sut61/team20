import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakefoodAddComponent } from './makefood-add.component';

describe('MakefoodAddComponent', () => {
  let component: MakefoodAddComponent;
  let fixture: ComponentFixture<MakefoodAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakefoodAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakefoodAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
