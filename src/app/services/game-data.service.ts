import {Injectable} from '@angular/core';
import {MOCK_DATA} from '../api/dev.api';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {GameSelectorDataInterface} from '../interfaces/game-selector-data.interface';

@Injectable({
  providedIn: 'root'
})
export class GameDataService {

  constructor(
    private http: HttpClient
  ) {
  }

  public gameSelectorsConfigRequest(): Observable<any> {
    const url = `${MOCK_DATA}/game-selector-data.json`;
    return this.http.get(url);
  }
  
  public parseSelectorsConfigResponse(data): GameSelectorDataInterface[] {
    return data.map((item) => {
      return {
        regionId: item.region_id,
        regionName: item.region_name,
        regionMapCenter: item.region_map_center.split(','),
        regionUsersOnline: item.region_users_online,
        regionThumb: item.region_thumb
      };
    });
  }
}
