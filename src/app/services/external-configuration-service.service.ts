import {Injectable} from '@angular/core';
import {ExternalConfigurationHandlerInterface, ExternalConfiguration} from '@lagoshny/ngx-hal-client';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable()
export class ExternalConfigurationService  implements ExternalConfigurationHandlerInterface   {

  constructor(public http: HttpClient) {
  }

  getProxyUri(): string {
    return environment.apiUrl; // 'http://localhost:8080/api/';
  }

  getRootUri(): string {
    return 'http://localhost:8080/api/';
  }

  // @ts-ignore
  getHttp(): HttpClient {
    return this.http;
  }

  getExternalConfiguration(): ExternalConfiguration {
    return null;
  }

  setExternalConfiguration(externalConfiguration: ExternalConfiguration) {}
  deserialize(): any {}
  serialize(): any {}
}
