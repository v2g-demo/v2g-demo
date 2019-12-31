import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './components/not-found/not-found.component';

import { GameSelectorComponent } from './components/game-selector/game-selector.component';
import {GameDataService} from './services/game-data.service';
import {HttpClientModule} from '@angular/common/http';
import { AboutComponent } from './components/about/about.component';
import {AuthGuardService} from './services/auth-guard.service';
import {LeafletModule} from '@asymmetrik/ngx-leaflet';
import { LefleatMapComponent } from './components/lefleat-map/lefleat-map.component';
import {MapComponent} from './components/map/map.component';
import { InfoPanelComponent } from './components/info-panel/info-panel.component';
import { GameComponent } from './components/game/game.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import {NgxHalClientModule} from '@lagoshny/ngx-hal-client';
import {HeaderComponent} from './header/header.component';
import {ExternalConfigurationService} from './services/external-configuration-service.service';
import {ObjectService} from './services/object.service';



@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    MapComponent,
    GameSelectorComponent,
    AboutComponent,
    LefleatMapComponent,
    InfoPanelComponent,
    GameComponent,
    SidebarComponent,
    HeaderComponent,
  ],
  entryComponents: [],
  imports: [
    BrowserModule,
    IonicModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    NgxHalClientModule.forRoot(),
    LeafletModule.forRoot(),
    // AgmCoreModule.forRoot({
    //   apiKey: environment.googleMapsApiKey
    // }),
    // AgmSnazzyInfoWindowModule

  ],
  providers: [
    StatusBar,
    SplashScreen,
    GameDataService,
    AuthGuardService,
    ObjectService,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    {provide: 'ExternalConfigurationService', useClass: ExternalConfigurationService}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
