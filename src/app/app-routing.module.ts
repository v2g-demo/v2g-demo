import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {GameSelectorComponent} from './components/game-selector/game-selector.component';
import {GameComponent} from './components/game/game.component';
import {AboutComponent} from './components/about/about.component';
import {AuthGuardService} from './services/auth-guard.service';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: GameSelectorComponent },
  { path: 'about', component: AboutComponent},
  { path: 'map/:id', component: GameComponent, canActivate: [AuthGuardService]},
  { path: '404', component: NotFoundComponent},
  { path: '**', redirectTo: '404'},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules, useHash: true })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}

