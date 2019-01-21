import { TestBed } from '@angular/core/testing';

import { ReportProblemService } from './report-problem.service';

describe('ReportProblemService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReportProblemService = TestBed.get(ReportProblemService);
    expect(service).toBeTruthy();
  });
});
