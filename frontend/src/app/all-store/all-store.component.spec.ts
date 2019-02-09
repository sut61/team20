import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllStoreComponent } from './all-store.component';

describe('AllStoreComponent', () => {
  let component: AllStoreComponent;
  let fixture: ComponentFixture<AllStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
