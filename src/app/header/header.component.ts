import {Component, Input, OnInit} from '@angular/core';
import {AuthGuardService} from '../services/auth-guard.service';
import {ActivatedRoute} from '@angular/router';
import {AngularFireAuth} from '@angular/fire/auth';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  hasVerifiedEmail = true;
  loggedIn: boolean;
  @Input() title: string;


  constructor(private authService: AuthGuardService, private route: ActivatedRoute, public afAuth: AngularFireAuth) {

    this.afAuth.authState.subscribe(user => {
      if (user) {
        authService.login(afAuth.auth.currentUser.displayName);
        this.hasVerifiedEmail = this.afAuth.auth.currentUser.emailVerified;
      }
    });

    route.params.subscribe(val => {
      this.checkLogin();
    });
  }

  signOut() {
    this.afAuth.auth.signOut().then(() => {
      location.reload();
    });
  }

  ngOnInit() {
    this.checkLogin();
  }

  checkLogin() {
    this.loggedIn = false;
    // this.user = this.auth.getAuthenticatedUserName();
    // this.loggedIn = this.auth.getAuthenticatedUser() !== null;
    // console.log('is logged in: ', this.loggedIn);
  }

}
