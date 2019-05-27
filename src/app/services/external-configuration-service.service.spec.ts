import { TestBed } from '@angular/core/testing';

import { ExternalConfigurationServiceService } from './external-configuration-service.service';

describe('ExternalConfigurationServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExternalConfigurationServiceService = TestBed.get(ExternalConfigurationServiceService);
    expect(service).toBeTruthy();
  });
});
