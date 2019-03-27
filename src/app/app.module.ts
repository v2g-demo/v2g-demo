import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

import { AgmCoreModule } from '@agm/core';
import { AgmSnazzyInfoWindowModule } from '@agm/snazzy-info-window';

import { MapComponent } from './components/map/map.component';
import { GameSelectorComponent } from './components/game-selector/game-selector.component';
import { environment } from '../environments/environment';
import { GameSelectorItemComponent } from './components/game-selector-item/game-selector-item.component';
import {GameDataService} from './services/game-data.service';
import {HttpClientModule} from '@angular/common/http';
import { AboutComponent } from './components/about/about.component';
import { GameComponent } from './components/game/game.component';
import { GameSidebarComponent } from './components/game-sidebar/game-sidebar.component';



// const DEMOS = [
//   NgbdAccordionModule,
//   NgbdAlertModule,
//   NgbdButtonsModule,
//   NgbdCarouselModule,
//   NgbdCollapseModule,
//   NgbdDatepickerModule,
//   NgbdDropdownModule,
//   NgbdModalModule,
//   NgbdPaginationModule,
//   NgbdPopoverModule,
//   NgbdProgressbarModule,
//   NgbdRatingModule,
//   NgbdTableModule,
//   NgbdTabsetModule,
//   NgbdTimepickerModule,
//   NgbdTooltipModule,
//   NgbdTypeaheadModule
// ];

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    NotFoundComponent,
    MapComponent,
    GameSelectorComponent,
    GameSelectorItemComponent,
    AboutComponent,
    GameComponent,
    GameSidebarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: environment.googleMapsApiKey
    }),
    AgmSnazzyInfoWindowModule

  ],
  providers: [GameDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
