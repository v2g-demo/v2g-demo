
export class GameMap {
  id: string;
  name: string;
  usersOnline: number;
  latitude: number;
  longitude: number;
  zoom: number;
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
