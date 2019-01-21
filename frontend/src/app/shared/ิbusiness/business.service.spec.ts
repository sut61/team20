import { TestBed } from '@angular/core/testing';

import { BusinessService } from './business.service';

describe('BusinessService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BusinessService = TestBed.get(BusinessService);
    expect(service).toBeTruthy();
  });
});
