import { TestBed } from '@angular/core/testing';

import { NutriService } from './nutri.service';

describe('NutriService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NutriService = TestBed.get(NutriService);
    expect(service).toBeTruthy();
  });
});
