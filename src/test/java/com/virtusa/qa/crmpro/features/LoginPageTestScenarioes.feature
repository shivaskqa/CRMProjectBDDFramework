Feature: Login Page validation
Scenario: Successful validation with valid credentials
Given that user launches the application
When user enters valid username,password and click on Login button
Then Home Page should be displayed

@logintest
Scenario Outline: Successful validation with valid credentials
Given that user launches the application
When user enters "<username>","<password>" and click on Login button
Then Home Page should be displayed successfully

Examples:
|username|password|
|naveenk|test123|
|shiva|test|
|xyz|testpass|
