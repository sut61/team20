import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateSerialCodeComponent } from './generate-serial-code.component';

describe('GenerateSerialCodeComponent', () => {
  let component: GenerateSerialCodeComponent;
  let fixture: ComponentFixture<GenerateSerialCodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenerateSerialCodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerateSerialCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
