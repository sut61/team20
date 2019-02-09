import { TestBed } from '@angular/core/testing';

import { ReviewfoodService } from './reviewfood.service';

describe('ReviewfoodService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReviewfoodService = TestBed.get(ReviewfoodService);
    expect(service).toBeTruthy();
  });
});
