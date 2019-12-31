import {Injectable, Injector} from '@angular/core';
import {RestService} from 'angular4-hal';
import {Observable} from 'rxjs';
import {User} from './game.data';

@Injectable()
export class UserService extends RestService<User> {

    constructor(injector: Injector) {
        super(User, 'users', injector);
    }

    // public findByName(name: string): Observable<User[]> {
    //     const options: any = {params: [{key: 'name', value: name}]};
    //     // @ts-ignore
    //     return this.search('findByName', options);
    // }
    //
    // public findByMap(mapId: string): Observable<MapObject[]> {
    //     const options: any = {params: [{key: 'map', value: mapId}]};
    //     // @ts-ignore
    //     return this.searchSingle('findByBusinessName', options);
    // }
}
