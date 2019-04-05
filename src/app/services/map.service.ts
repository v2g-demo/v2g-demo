import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {interval, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {tap} from 'rxjs/internal/operators/tap';
import {flatMap} from 'rxjs/operators';
import {GameMap} from './game.data';


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

  getObjects(mapId: number): Observable<any> {

    return interval(1000).pipe(flatMap( () => {
      const command = environment.apiUrl + '/maps/' + mapId + '/objects';

      return this.http.get(command);
    }));


  }

  public parseMapsData(data): GameMap[] {
    return data.content.map((item) => {
      return {
        id: item.id,
        name: item.name,
        latitude: item.center.latitude,
        longitude: item.center.longitude,
        zoom: item.zoom
      };
    });
  }

}

