Feature: Free CRM Login Feature
Scenario: Free CRM Login Test without parameters

Given user is already on login2 page
When title of login2 page is Free CRM
Then user enters2 username and password
Then user clicks on login2 button
And user is on homepage2
Then close the browser2