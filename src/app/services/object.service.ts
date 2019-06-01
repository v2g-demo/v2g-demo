import {Injectable, Injector} from '@angular/core';
import {RestService} from 'angular4-hal';
import {Observable} from 'rxjs';

import {Resource} from 'angular4-hal';

export class MapObject extends Resource {

    // id: number;
    name: string;
    placeId: string;
    formattedAddress: string;
    location: {latitude: number; longitude: number};
    type: string;
    // players: Player[];
}

@Injectable()
export class ObjectService extends RestService<MapObject> {

    constructor(injector: Injector) {
        super(MapObject, 'objects', injector);
    }

    public findByName(name: string): Observable<MapObject[]> {
        const options: any = {params: [{key: 'name', value: name}]};
        // @ts-ignore
        return this.search('findByName', options);
    }

    public findByMap(mapId: string): Observable<MapObject[]> {
        const options: any = {params: [{key: 'map', value: mapId}]};
        // @ts-ignore
        return this.searchSingle('findByBusinessName', options);
    }
}
