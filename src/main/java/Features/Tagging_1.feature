#This feature file will be using Tagging concept
Feature: Free CRM application testing with Tagging concept

@SmokeTest @RegressionTest
Scenario: Login with correct username and correct password
Given This is a valid login test

@RegressionTest @End2End
Scenario: Login with in-correct username and correct password
Given This is an in-valid login test

@SmokeTest @RegressionTest
Scenario: Create a contact
Given This is a valid contact creation test case

@RegressionTest @End2End
Scenario: Edit a contact
Given This is a valid contact editing test case

@SmokeTest @RegressionTest
Scenario: Delete a contact
Given This is a valid contact deletion test case

@SmokeTest @End2End
Scenario: Create a deal
Given This is a valid deal creation test case

@RegressionTest @End2End
Scenario: Update a deal
Given This is a valid deal updation test case

@SmokeTest @End2End
Scenario: Delete a deal
Given This is a valid deal deletion test case

@SmokeTest @End2End
Scenario: Create a task
Given This is a valid task creation test case

@RegressionTest @End2End
Scenario: Update a task
Given This is a valid task updation test case

@SmokeTest @End2End
Scenario: Delete a task
Given This is a valid task deletion test case

@SmokeTest @End2End
Scenario: Create a company
Given This is a valid company creation test case

@RegressionTest @End2End
Scenario: Update a company
Given This is a valid company updation test case

@SmokeTest @End2End
Scenario: Delete a company
Given This is a valid company deletion test case

@End2End
Scenario: Search functionality test
Given This is a test case to test search functionality

@End2End
Scenario: Test docs and forms
Given This is a test case to validate docs and forms

@End2End
Scenario: Test Reports
Given This is a test case to validate reports

@End2End
Scenario: Logout functionality
Given This is a test case to validate logout functionality