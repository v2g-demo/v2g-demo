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

}
