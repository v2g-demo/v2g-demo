import {Component, OnInit} from '@angular/core';
import {GameDataService} from '../../services/game-data.service';
import {GameSelectorDataInterface} from '../../interfaces/game-selector-data.interface';

@Component({
  selector: 'app-game-selector',
  templateUrl: './game-selector.component.html',
  styleUrls: ['./game-selector.component.scss']
})
export class GameSelectorComponent implements OnInit {
  public gameSelectorsData: GameSelectorDataInterface[];

  constructor(
    private gameDataService: GameDataService
  ) {
  }

  public ngOnInit() {
    this.getGameSelectorItems();
  }

  private getGameSelectorItems() {
    this.gameDataService.gameSelectorsConfigRequest().subscribe((response) => {
      this.gameSelectorsData = this.gameDataService.parseSelectorsConfigResponse(response);
    });
  }

}
