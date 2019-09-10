Feature: Login Functionality

  Background: 
    Given I Navigate to Application

  @Hello
  Scenario Outline: Login
    When I Entered UserName "<rownum>"
    Then I Entered Password "<rownum>"
    
    Examples:
    |rownum|
    |1|
    |2|
