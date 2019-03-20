import { Component, OnInit } from '@angular/core';
import {MapConstants} from "./map-constants";
import {MarkerInterface} from "../../interfaces/marker.interface";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {
  public markers: MarkerInterface[] = MapConstants.MARKERS_MOCK;
  private selectedMarker;

  constructor() { }

  public ngOnInit() {

  }

  public selectMarker(event) {
    this.selectedMarker = {
      lat: event.latitude,
      lng: event.longitude
    };
  }

  public addMarker(lat: number, lng: number) {
    this.markers.push({ lat, lng, alpha: 0.4 });
  }

  public max(coordType: 'lat' | 'lng'): number {
    return Math.max(...this.markers.map(marker => marker[coordType]));
  }

  public min(coordType: 'lat' | 'lng'): number {
    return Math.min(...this.markers.map(marker => marker[coordType]));
  }


}
