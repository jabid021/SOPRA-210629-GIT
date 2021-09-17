import { TestBed } from '@angular/core/testing';

import { NoAuthCanActivateService } from './no-auth-can-activate.service';

describe('NoAuthCanActivateService', () => {
  let service: NoAuthCanActivateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NoAuthCanActivateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
