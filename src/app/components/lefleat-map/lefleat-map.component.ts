import {Component, Input, OnInit} from '@angular/core';
import {circle, icon, latLng, marker, polygon, tileLayer} from 'leaflet';
import {MapService} from '../../services/map.service';
import {ActivatedRoute} from '@angular/router';

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
    overlays: {'Big Circle': circle([52.520008, 13.404954], {radius: 5000})}
  };

  layers = [];
  // layers = [
  //   marker([ 52.520008, 13.404954 ],{
  //     icon: icon({
  //       iconSize: [ 25, 41 ],
  //       iconAnchor: [ 13, 41 ],
  //       iconUrl: 'assets/marker-icon.png',
  //       shadowUrl: 'assets/marker-shadow.png'
  //     })
  //   })
  // ];

  constructor(public route: ActivatedRoute, private mapService: MapService) {
  }

  ngOnInit() {
    const id = this.route.snapshot.params.id;
    this.mapService.getObjects(id).subscribe((data) => {
      console.log(data);
      const m = marker([52.520008, 13.404954], {
        icon: icon({
          iconSize: [25, 41],
          iconAnchor: [13, 41],
          iconUrl: 'assets/marker-icon.png',
          shadowUrl: 'assets/marker-shadow.png'
        })
      });
      this.layers.push(m);
    });

  }

}
