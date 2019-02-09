import { TestBed } from '@angular/core/testing';

import { GeneratecodeService } from './generatecode.service';

describe('GeneratecodeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GeneratecodeService = TestBed.get(GeneratecodeService);
    expect(service).toBeTruthy();
  });
});
