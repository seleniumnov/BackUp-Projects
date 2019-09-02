Feature: Login Functionality
  
  Background: 
  	Given  I Navigate to Application

  @Smoke
  Scenario Outline: Verify User Credentials
    Given I Entered UserName "<rowNum>"
    When I Entered Password  "<rowNum>"

    Examples: 
      | rowNum |
      |      1 |
     
