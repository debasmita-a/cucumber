Feature: Login page feature

Scenario: Login page title
Given user is on the login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given user is on the login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on the login page
When user enters username "dec2020secondbatch@gmail.com"
And user enters password "Selenium@12345"
And user clicks on the Login button
Then user gets the title of the page
And page title should be "My account - My Store"

