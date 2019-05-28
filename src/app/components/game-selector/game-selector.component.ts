import {Component, OnInit} from '@angular/core';
import {MapService} from '../../services/map.service';
import {Map, latLng, MapOptions, tileLayer} from 'leaflet';
import {GameMap} from '../../services/game.data';

@Component({
  selector: 'app-game-selector',
  templateUrl: './game-selector.component.html',
  styleUrls: ['./game-selector.component.scss']
})
export class GameSelectorComponent implements OnInit {
  public gameSelectorsData: GameMap[];

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

  ionViewWillLeave() {
    // this.map.remove();
  }

  makeOptions(data: GameMap): MapOptions {
    const result = this.mapOptions;
    result.center = latLng(data.latitude, data.longitude);
    result.zoom = data.zoom;
    return  result;
  }

  // https://edupala.com/how-to-add-leaflet-map-in-ionic-4/
}
