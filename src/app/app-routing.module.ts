import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './components/welcome/welcome.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {MapComponent} from './components/map/map.component';
import {GameSelectorComponent} from './components/game-selector/game-selector.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: GameSelectorComponent },
  { path: 'map', component: MapComponent },
  { path: 'map/:id', component: MapComponent },
  {path: '404', component: NotFoundComponent},
  {path: '**', redirectTo: '404'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
