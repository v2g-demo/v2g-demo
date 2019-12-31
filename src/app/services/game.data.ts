import {Resource} from '@lagoshny/ngx-hal-client';

export class Location {
  latitude: number; longitude: number;
}

export class GameMap extends Resource {
  constructor() {
    super();
  }
  id: string;
  name: string;
  center: Location;
  zoom: number;
  objects: MapObject[];
}


export class Character {
  id: number;
  name: string;
  walletId: number;
  mapId: number;
}

export class GameData {
  time: number;
  timeMultiplier: number;
  priceHistory: number[];
  consumptionHistory: number[];
  topPlayers: number[]; // player ids
}

export class Wallet {
  id: number;
  value: number;
}

export class MapObject extends Resource {
  constructor() {
    super();
  }
  // id: number;
  name: string;
  placeId: string;
  formattedAddress: string;
  location: Location;
  type: string;
}

export class User extends Resource {
  name: string;
}
