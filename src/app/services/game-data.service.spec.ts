import { TestBed } from '@angular/core/testing';

import { GameDataService } from './game-data.service';
import {HttpClientTestingModule} from '@angular/common/http/testing';

describe('GameDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule]
  }));

  it('should be created', () => {
    const service: GameDataService = TestBed.get(GameDataService);
    expect(service).toBeTruthy();
  });
});
