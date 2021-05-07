Feature: User would like to verify all negative scenarios for login

Scenario Outline:  Sign in with negative Scenarios

Given user should able to launch the application
When user is in sport page
Then User able to click on Sign in
And User should give Email as  "<email>" and password as"<password>"
And User should click on Sign in
And user should get error message
And user able to close the application

Examples:
|email|password|
#|ramu.datastagepx@gmail.com|ramu@123|
|ramu.rfgthkd@gmail.com|ramum1234|
#|ram.demo@gmail.com|football|
#|ramu.datastagepx@gmail.com||
#||ramum1234|
|||
