
// base
export class GameInfo {
  id: number;
  name: string;
  playersOnline: number; // count
}

export class Player {
  id: number;
  name: string;
  walletId: number;
  gameId: number; // GameInfo.id
}

export class GameData {
  info: GameInfo;
  time: number;
  timeMultiplier: number;
  priceHistory: number[];
  consumptionHistory: number[];
  topPlayers: number[]; // player ids



  // isOnline: boolean;
  // currentFirmvare?: string = '';
  // currentFirmvareName?: string;
  // firmwares: FirmwareModel[] = [];
  // sensors?: SensorModel[] = [];
  // lastSeen?: string;
  // redlist?: string;

}

export class Wallet {
  id: number;
  value: number;
}
