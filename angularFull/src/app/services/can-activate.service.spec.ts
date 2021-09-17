import { TestBed } from '@angular/core/testing';

import { AllUserCanActivateService } from './all-user-can-activate.service';

describe('CanActivateService', () => {
  let service: AllUserCanActivateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllUserCanActivateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
