import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MapComponent } from './map.component';
import {MapConstants} from "./map-constants";
import {AgmCoreModule} from "@agm/core";
import {AgmSnazzyInfoWindowModule} from "@agm/snazzy-info-window";

xdescribe('MapComponent', () => {
  let component: MapComponent;
  let fixture: ComponentFixture<MapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MapComponent ],
      imports: [
        AgmCoreModule.forRoot({
          apiKey: 'API_KEY'
        }),
        AgmSnazzyInfoWindowModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should be equal', () => {
    component.markers = [
      {
        lat: 12.09407,
        lng: 26.31618,
        alpha: 1,
        icon: {
          path: MapConstants.MARKERS_ICONS['hospital'],
          rotation: 0,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22,
          }
        },
      },
      {
        lat: 47.92393,
        lng: 78.58339,
        alpha: 1,
        icon: {
          path: MapConstants.MARKERS_ICONS['gasStation'],
          rotation: 0,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22,
          }
        },
      }
    ];
    component.selectedMarker = 1;
    component.rotateMarker(300);
    expect(component.markers[0].icon.rotation).toEqual(300);
  });
});
