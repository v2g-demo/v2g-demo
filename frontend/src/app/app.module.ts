import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { WelcomeComponent } from './welcome/welcome.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { MapboxmapComponent } from './mapboxmap/mapboxmap.component';
import { NgxMapboxGLModule } from 'ngx-mapbox-gl';


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
    MapboxmapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,

    NgxMapboxGLModule.withConfig({
      accessToken: 'pk.eyJ1IjoiYnJvbmluIiwiYSI6ImNqc2YzZGY0ejAwYWo0OW8ybnNiZHFkYXcifQ.r0Ql3m62AFAijSbWxGDkWQ', // Optionnal, can also be set per map (accessToken input of mgl-map)
      geocoderAccessToken: 'pk.eyJ1IjoiYnJvbmluIiwiYSI6ImNqc2YzZGY0ejAwYWo0OW8ybnNiZHFkYXcifQ.r0Ql3m62AFAijSbWxGDkWQ' // Optionnal, specify if different from the map access token, can also be set per mgl-geocoder (accessToken input of mgl-geocoder)
    })
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
