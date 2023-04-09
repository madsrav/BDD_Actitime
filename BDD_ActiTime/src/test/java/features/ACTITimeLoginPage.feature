#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: ActitimeTaskModule

@SmokeTest 
Scenario: As a valid user i want to verify home page title
Then home page will display
Then Also I will verify that home page title

@Functional @Regression
Scenario: As a user i want to add new customer in Tasks module after Login with valid Username and Password 

And Click on Tasks Module
Then click on add new button
Then create new customer page will display
And enter all details and click on createcustomer button
And Also i will verify that created name



