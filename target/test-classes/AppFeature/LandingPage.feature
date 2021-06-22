Feature: Landing page feature

Background:
Given User has laready logged in to the application
|username|password|
|test1   |acid_qa |

Scenario: Landing page title
Given user is on Leads landing page
When user gets the title of the page
Then page title should be "CRMnext - Smart.Easy.Complete"


Scenario: To open new edit layout
Given user is on Leads landing page
When user clicks on new button
And user clicks on "Khoản vay"


