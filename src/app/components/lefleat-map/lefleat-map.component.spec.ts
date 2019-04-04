import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LefleatMapComponent } from './lefleat-map.component';

describe('LefleatMapComponent', () => {
  let component: LefleatMapComponent;
  let fixture: ComponentFixture<LefleatMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LefleatMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LefleatMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
