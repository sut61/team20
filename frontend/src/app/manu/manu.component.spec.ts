import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManuComponent } from './manu.component';

describe('ManuComponent', () => {
  let component: ManuComponent;
  let fixture: ComponentFixture<ManuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
