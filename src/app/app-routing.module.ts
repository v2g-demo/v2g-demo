import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: './home/home.module#HomePageModule'
  },
  {
    path: 'list',
    loadChildren: './list/list.module#ListPageModule'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}

/*
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {GameSelectorComponent} from './components/game-selector/game-selector.component';
import { AboutComponent } from './components/about/about.component';
import {AuthGuardService} from './services/auth-guard.service';
import {GameComponent} from './components/game/game.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: GameSelectorComponent },
  { path: 'about', component: AboutComponent},
  { path: 'map/:id', component: GameComponent, canActivate: [AuthGuardService]},
  { path: '404', component: NotFoundComponent},
  { path: '**', redirectTo: '404'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
*/
