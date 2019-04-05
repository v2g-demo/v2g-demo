import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {interval, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {tap} from 'rxjs/internal/operators/tap';
import {GameSelectorDataInterface} from '../interfaces/game-selector-data.interface';


@Injectable({
  providedIn: 'root'
})
export class MapService {

  constructor(private http: HttpClient) {
  }

  getMaps(): Observable<any> {
    const command = environment.apiUrl + '/maps';
    return this.http.get(command).pipe(
      tap( // Log the result or error
        data => console.log(data),
        error => console.log(error)
      )
    );
  }

  // getObjects(deviceId: string): Observable<Object> {
  //   const command = environment.apiUrl + '/maps/' + deviceId + '/objects';
  //
  //   return interval(1000).pipe(flatMap( () => {return this.http.get<command>(this.serviceUrl + "/Clients")}));
  //
  //
  // }

  public parseMapsData(data): GameSelectorDataInterface[] {
    return data._embedded.maps.map((item) => {
      return {
        id: item.id,
        name: item.name,
        latitude: item.center.latitude,
        longitude: item.center.longitude,
        zoom: 5// item.zoom
      };
    });
  }

}

