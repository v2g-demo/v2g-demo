import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {GameSelectorComponent} from './components/game-selector/game-selector.component';
import { AboutComponent } from './components/about/about.component';
import {AuthGuardService} from './services/auth-guard.service';
import {LefleatMapComponent} from './components/lefleat-map/lefleat-map.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: GameSelectorComponent },
  { path: 'about', component: AboutComponent},
  { path: 'map/:id', component: LefleatMapComponent, canActivate: [AuthGuardService]},
  { path: '404', component: NotFoundComponent},
  { path: '**', redirectTo: '404'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
