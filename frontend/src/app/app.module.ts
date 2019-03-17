import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { WelcomeComponent } from './welcome/welcome.component';
import { NotFoundComponent } from './not-found/not-found.component';

import { AgmCoreModule } from '@agm/core';
import { AgmSnazzyInfoWindowModule } from '@agm/snazzy-info-window';

import { MapComponent } from './map/map.component';


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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    AgmCoreModule.forRoot({
      apiKey: 'API_KEY'
    }),
    AgmSnazzyInfoWindowModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
