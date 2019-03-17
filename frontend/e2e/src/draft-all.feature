
 Feature: Game map selection
   Scenario: User Choose game map
     When I as User open start
     Then I should see welcome text
     And I should see map selection widget
     When I choose a game map
     Then the game starts

  Feature: Navigation main menu
   Scenario: About page
     When I as User open start page
     And click to main navigation item About
     Then I should see About page

   Scenario: Sing up, sigh in, oauth

   Scenario: settings
   Scenario: Map switching - mapbox\google maps

 Feature: The game process
  Scenario: Map object info on sidebar
  Scenario: Header time widget
  Scenario: Header electricity price widget\chart
  Scenario: Header power consumption widget\chart
  Scenario: Header game statistics widget: users count, money, SmartGrid health

    Feature: A route builder, map details switcher,
    Feature: simple game chat
