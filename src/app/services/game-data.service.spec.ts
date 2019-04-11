import {TestBed} from '@angular/core/testing';

import {GameDataService} from './game-data.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';

xdescribe('GameDataService', () => {
  let service: GameDataService;
  let httpTestingController: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [GameDataService]
    });
    httpTestingController = TestBed.get(HttpTestingController);
    service = TestBed.get(GameDataService);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  // it('should return an Observable', () => {
  //
  //
  //   service.gameSelectorsConfigRequest().subscribe(gamesData => {
  //     expect(gamesData.length).toBe(3);
  //     expect(gamesData).toEqual(dummyData);
  //   });
  //
  //   const req = httpTestingController.expectOne(`${MOCK_DATA}/game-selector-data.json`);
  //   expect(req.request.method).toBe('GET');
  //   req.flush(dummyData);
  // });
  //
  // it('should be equal', () => {
  //
  //
  //   const parsedData = service.parseSelectorsConfigResponse(dummyData);
  //   expect(JSON.stringify(parsedData)).toEqual(JSON.stringify(parsedDummyData));
  // });
});
