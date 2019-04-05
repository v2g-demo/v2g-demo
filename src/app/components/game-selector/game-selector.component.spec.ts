import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameSelectorComponent } from './game-selector.component';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {GameDataService} from '../../services/game-data.service';
import {GameSelectorDataInterface} from '../../interfaces/game-selector-data.interface';

describe('GameSelectorComponent', () => {
  let component: GameSelectorComponent;
  let fixture: ComponentFixture<GameSelectorComponent>;
  let service: GameDataService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    service = TestBed.get(GameDataService);
  });

});
