export interface MarkerInterface {
  lat: number;
  lng: number;
  alpha?: number;
  icon?: IconInterface;
}

interface IconInterface {
  fillColor?: string;
  fillOpacity?: number;
  path?: string;
  rotation?: number;
  scale?: number;
  strokeColor?: string;
  strokeOpacity?: number;
  strokeWeight?: number;
}
