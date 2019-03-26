import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameSelectorItemComponent } from './game-selector-item.component';

describe('GameSelectorItemComponent', () => {
  let component: GameSelectorItemComponent;
  let fixture: ComponentFixture<GameSelectorItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameSelectorItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameSelectorItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
