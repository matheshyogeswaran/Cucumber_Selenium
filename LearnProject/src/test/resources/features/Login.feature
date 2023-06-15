Feature: Login function


Scenario: Login with valid credentials
Given User has navigated to login page
When User enters valid email address "ben1@gmail.com" into email field
And User enters valid password "ben123" into password field
And User clicks on Login button
Then User should get successfully logged in

