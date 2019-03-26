import {Component, Input, OnInit} from '@angular/core';
import {GameSelectorDataInterface} from '../../interfaces/game-selector-data.interface';

@Component({
  selector: 'app-game-selector-item',
  templateUrl: './game-selector-item.component.html',
  styleUrls: ['./game-selector-item.component.scss']
})
export class GameSelectorItemComponent implements OnInit {
  @Input()
  public gameSelectorItemConfig: GameSelectorDataInterface;
  constructor() { }

  ngOnInit() {
  }

}
