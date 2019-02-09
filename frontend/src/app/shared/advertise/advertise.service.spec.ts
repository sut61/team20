import { TestBed } from '@angular/core/testing';

import { AdvertiseService } from './advertise.service';

describe('AdvertiseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdvertiseService = TestBed.get(AdvertiseService);
    expect(service).toBeTruthy();
  });
});
