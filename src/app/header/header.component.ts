import {Component, Input, OnInit} from '@angular/core';
import {AuthGuardService} from '../services/auth-guard.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {

  loggedIn: boolean;
  user: string;
  @Input() title: string;

  constructor(private auth: AuthGuardService, private route: ActivatedRoute) {

    route.params.subscribe(val => {
      this.checkLogin();
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
