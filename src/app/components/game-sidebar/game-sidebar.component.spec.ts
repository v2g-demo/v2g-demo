import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GameSidebarComponent } from './game-sidebar.component';

describe('GameSidebarComponent', () => {
  let component: GameSidebarComponent;
  let fixture: ComponentFixture<GameSidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GameSidebarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GameSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
