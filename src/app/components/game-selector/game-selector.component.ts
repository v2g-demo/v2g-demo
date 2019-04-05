import {Component, OnInit} from '@angular/core';
import {GameSelectorDataInterface} from '../../interfaces/game-selector-data.interface';
import {MapService} from '../../services/map.service';
import {latLng, MapOptions, tileLayer} from 'leaflet';

@Component({
  selector: 'app-game-selector',
  templateUrl: './game-selector.component.html',
  styleUrls: ['./game-selector.component.scss']
})
export class GameSelectorComponent implements OnInit {
  public gameSelectorsData: GameSelectorDataInterface[];

  mapOptions = {
    layers: [tileLayer('http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}', { maxZoom: 20, subdomains: ['mt0', 'mt1', 'mt2', 'mt3']})],
    zoom: 11,
    center: latLng(55.751244, 37.618423)
  };

  constructor(
    private mapService: MapService
  ) {
  }

  public ngOnInit() {

    this.mapService.getMaps().subscribe(data => {
    this.gameSelectorsData = this.mapService.parseMapsData(data);
    });
  }

  makeOptions(data: GameSelectorDataInterface): MapOptions {
    const result = this.mapOptions;
    result.center = latLng(data.latitude, data.longitude);
    // result.zoom = data.zoom;
    return  result;
  }


}
