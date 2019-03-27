import {TestBed} from '@angular/core/testing';

import {GameDataService} from './game-data.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {MOCK_DATA} from '../api/dev.api';
import {GameSelectorDataInterface} from '../interfaces/game-selector-data.interface';

describe('GameDataService', () => {
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

  it('should return an Observable', () => {
    const dummyData = [
      {
        region_id: '0001',
        region_name: 'Frankfurt am Main',
        region_map_center: '50.110427,8.672922',
        region_users_online: '511',
        region_thumb: './assets/img/frankfurt.jpg'
      },
      {
        region_id: '0002',
        region_name: 'Warszawa',
        region_map_center: '52.214315,21.047821',
        region_users_online: '225',
        region_thumb: './assets/img/warszawa.jpg'
      },
      {
        region_id: '0003',
        region_name: 'Linz',
        region_map_center: '48.306792,14.285954',
        region_users_online: '1113',
        region_thumb: './assets/img/linz.jpg'
      }
    ];

    service.gameSelectorsConfigRequest().subscribe(gamesData => {
      expect(gamesData.length).toBe(3);
      expect(gamesData).toEqual(dummyData);
    });

    const req = httpTestingController.expectOne(`${MOCK_DATA}/game-selector-data.json`);
    expect(req.request.method).toBe('GET');
    req.flush(dummyData);
  });

  it('should be equal', () => {
    const dummyData = [
      {
        region_id: '0003',
        region_name: 'Linz',
        region_map_center: '48.306792,14.285954',
        region_users_online: '1113',
        region_thumb: './assets/img/linz.jpg'
      }
    ];
    const parsedDummyData: GameSelectorDataInterface[] = [
      {
        regionId: '0003',
        regionName: 'Linz',
        regionMapCenter: ['48.306792', '14.285954'],
        regionUsersOnline: '1113',
        regionThumb: './assets/img/linz.jpg'
      }
    ];
    const parsedData = service.parseSelectorsConfigResponse(dummyData);
    expect(JSON.stringify(parsedData)).toEqual(JSON.stringify(parsedDummyData));
  });
});
