Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Test Login | Practice Test Automation"

Scenario: Login with correct credentials
Given user is on login page
When user enters username "student"
And user enters password "Password123"
And user clicks on Login button
Then user gets the title of the page
And page title should be "Logged In Successfully | Practice Test Automation"