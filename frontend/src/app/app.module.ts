import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NgxMapboxGLModule } from 'ngx-mapbox-gl';
import { MapboxmapComponent } from './mapboxmap/mapboxmap.component';


@NgModule({
  declarations: [
    AppComponent,
    MapboxmapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

    NgxMapboxGLModule.withConfig({
      accessToken: 'pk.eyJ1IjoiYnJvbmluIiwiYSI6ImNqc2YzZGY0ejAwYWo0OW8ybnNiZHFkYXcifQ.r0Ql3m62AFAijSbWxGDkWQ', // Optionnal, can also be set per map (accessToken input of mgl-map)
      geocoderAccessToken: 'pk.eyJ1IjoiYnJvbmluIiwiYSI6ImNqc2YzZGY0ejAwYWo0OW8ybnNiZHFkYXcifQ.r0Ql3m62AFAijSbWxGDkWQ' // Optionnal, specify if different from the map access token, can also be set per mgl-geocoder (accessToken input of mgl-geocoder)
    })
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
