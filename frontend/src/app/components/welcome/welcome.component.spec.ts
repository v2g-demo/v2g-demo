import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WelcomeComponent } from './welcome.component';
import {Component} from '@angular/core';
import {MapComponent} from "../map/map.component";
import {GameSelectorComponent} from "../game-selector/game-selector.component";
import {AgmCoreModule} from "@agm/core";
import {AgmSnazzyInfoWindowModule} from "@agm/snazzy-info-window";

describe('WelcomeComponent', () => {
  let component: WelcomeComponent;
  let fixture: ComponentFixture<WelcomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WelcomeComponent, MockMapboxmapComponent, GameSelectorComponent, MapComponent ],
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
    fixture = TestBed.createComponent(WelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});


@Component({
  selector: 'app-mapboxmap',
  template: ''
})
class MockMapboxmapComponent {
}
