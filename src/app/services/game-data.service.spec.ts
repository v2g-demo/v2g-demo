import { TestBed } from '@angular/core/testing';

import { GameDataService } from './game-data.service';

describe('GameDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GameDataService = TestBed.get(GameDataService);
    expect(service).toBeTruthy();
  });
});
