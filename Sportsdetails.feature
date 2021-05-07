Feature: As a business user, I would like to make a record of all teams which are playing today

Scenario: how many team names are playing today

Given user should able to launch the application
When user is in sport page
Then user able to see today matches
And user should see all team names
And user should see message if no matches today
And user able to close the application