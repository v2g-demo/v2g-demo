import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {interval, Observable} from 'rxjs';
import {environment} from '../../environments/environment.prod';
import {tap} from 'rxjs/internal/operators/tap';
import {flatMap} from 'rxjs/operators';


@Injectable()
export class MapService {

  constructor(private http: HttpClient) {
  }

  getMaps(): Observable<Object> {
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
}

