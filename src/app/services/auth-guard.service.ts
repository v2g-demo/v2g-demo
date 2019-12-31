import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import {HttpClient} from '@angular/common/http';


@Injectable()
export class AuthGuardService implements CanActivate  {
  authenticatedUser = '';

  constructor(private http: HttpClient) { }

  getUthenticatedUser(): string {
    this.authenticatedUser = localStorage.getItem('characterId');
    return this.authenticatedUser;
  }

  canActivate(): boolean {
    this.authenticatedUser = localStorage.getItem('characterId');
    const isAuth = (this.authenticatedUser && this.authenticatedUser !== '');
    console.log('AuthGuard#canActivate called: ' + isAuth);
    // return isAuth;
    return true;
  }

  createUser(): string  {
    // this.http.get()
    return ''; // call api
  }

  login(username: string) {
    console.log('login:' + username);
    this.authenticatedUser = username;
    localStorage.setItem('authenticatedUser', this.authenticatedUser);
  }
  //
  // logout() {
  //   console.log('logout');
  //   this.authenticatedUser = '';
  //   localStorage.setItem('authenticatedUser', this.authenticatedUser);
  // }

}
