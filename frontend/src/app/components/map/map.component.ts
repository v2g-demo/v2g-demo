import {ApplicationRef, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {MapConstants} from "./map-constants";
import {MarkerInterface} from "../../interfaces/marker.interface";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {
  public markers: MarkerInterface[] = MapConstants.MARKERS_MOCK;
  public selectedMarker: number;

  constructor(
    private cdRef: ChangeDetectorRef,
    private appRef: ApplicationRef,
  ) { }

  public ngOnInit() {

  }

  public selectMarker(event, index) {
    this.selectedMarker = index + 1;
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

  public rotateMarker(angle) {
    const index = this.selectedMarker - 1;
    const updatedMarker: MarkerInterface = {...this.markers[index]};
    updatedMarker.icon.rotation = angle;
    this.markers.splice(index, 1, updatedMarker);
  }
}
