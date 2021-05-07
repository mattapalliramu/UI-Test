Feature: As a sports user, I would like to read about all articles related to sports

Scenario: User able to see sports news

Given user should able to launch the application
When user is in sport page
Then user should search for sports news as "sports"
And user should click enter
And user should see sports news page
And user should able to get first and last news headings
And user able to close the application