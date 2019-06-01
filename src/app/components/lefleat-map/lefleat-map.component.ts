import {Component, Input, OnInit} from '@angular/core';
import {circle, icon, latLng, marker, polygon, tileLayer} from 'leaflet';
import {MapService} from '../../services/map.service';
import {ActivatedRoute} from '@angular/router';
import {ObjectService} from '../../services/object.service';
import {MapObject} from '../../services/game.data';

@Component({
  selector: 'app-lefleat-map',
  templateUrl: './lefleat-map.component.html',
  styleUrls: ['./lefleat-map.component.scss']

})
export class LefleatMapComponent implements OnInit {
  @Input() location = '';
  options = {
    layers: [tileLayer('http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}', {maxZoom: 20, subdomains: ['mt0', 'mt1', 'mt2', 'mt3']})],
    zoom: 11,
    center: latLng(52.520008, 13.404954)
  };

  layersControl = {
    baseLayers: {
      'google Streets': tileLayer('http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}', {
        maxZoom: 20,
        subdomains: ['mt0', 'mt1', 'mt2', 'mt3']
      }),
      'Open Street Map': tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {maxZoom: 18, attribution: '...'})
    },
    // overlays: {'Big Circle': circle([52.520008, 13.404954], {radius: 5000})}
  };

  layers = [];

  constructor(public route: ActivatedRoute, private mapService: MapService, private objectService: ObjectService) {
  }

  ngOnInit() {
    const id = this.route.snapshot.params.id;

    this.objectService.getAll().subscribe((data: MapObject[]) => {

      data.map((obj: MapObject) => {
        console.log(obj);

        const m = marker([obj.location.latitude, obj.location.longitude], {
          title: obj.name,
          alt: obj.name,
          clickable: true,
          riseOnHover: true,
          icon: icon({
            iconSize: [16, 16],
            iconAnchor: [16, 16],
            iconUrl: 'assets/CHARGER.png',
            // shadowUrl: 'assets/marker-shadow.png'
          })
        });

        m.bindPopup('<ion-button size="small">charge</ion-button>');

          //   .on('click', (ev) => {
          // this.zone.run(() => {
          //   this.message = 'circle marker click';
          // });

        this.layers.push(m);
      });


    });

  }

  click(event) {
    console.log(event);

  }

}
