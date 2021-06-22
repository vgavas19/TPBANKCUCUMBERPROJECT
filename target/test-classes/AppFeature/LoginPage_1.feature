Feature: login page feature

Scenario: login page title
Given user is on login page
When user gets the title of the page
Then page title should be "CRMnext - Smart.Easy.Complete"

Scenario: Forgot password link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "test1"
And user enters password "acid_qa"
And user clicks on login button
Then user should be navigated to landing page
And text on landing page should be "Leads"