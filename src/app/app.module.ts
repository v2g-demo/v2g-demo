import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NotFoundComponent } from './components/not-found/not-found.component';


import { GameSelectorComponent } from './components/game-selector/game-selector.component';
import {GameDataService} from './services/game-data.service';
import {HttpClientModule} from '@angular/common/http';
import { AboutComponent } from './components/about/about.component';
import {AuthGuardService} from './services/auth-guard.service';
import {LeafletModule} from '@asymmetrik/ngx-leaflet';
import { LefleatMapComponent } from './components/lefleat-map/lefleat-map.component';



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
    NotFoundComponent,
//    MapComponent,
    GameSelectorComponent,
    AboutComponent,
    LefleatMapComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    LeafletModule.forRoot()
    // AgmCoreModule.forRoot({
    //   apiKey: environment.googleMapsApiKey
    // }),
    // AgmSnazzyInfoWindowModule

  ],
  providers: [GameDataService, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
