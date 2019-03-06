import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MapboxmapComponent } from './mapboxmap.component';

describe('MapboxmapComponent', () => {
  let component: MapboxmapComponent;
  let fixture: ComponentFixture<MapboxmapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MapboxmapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MapboxmapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
