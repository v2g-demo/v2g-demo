import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {MapService} from '../../services/map.service';
import {GameMap} from '../../services/game.data';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {

  title: string;

  constructor(public route: ActivatedRoute, private mapService: MapService) { }

  ngOnInit() {
    const id = this.route.snapshot.params.id;
    this.mapService.get(id).subscribe((data: GameMap) => {
      this.title = data.name;
    });
  }

}
