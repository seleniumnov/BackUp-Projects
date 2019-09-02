Feature: NCL Cruise Coach  Validation
  

  @test
  Scenario: Cruise Recommended Results
    Given I Click Cruise Coach Link
    When I Select Departure as my Important Factor
    And I Select Best Experience
    And I Select Accommodation and Departure
    And I Click on Next Button From Cruise Factors Page
    And I Validate Button Name based on Cruise Factors
    Then I Select Departure Ports
    And I Click on Continue Button
    Then I Select Maximum 2 Preference for Destination
    Then I Click on Dates&Pricing Button
    #And I Select Flexible Dates, Number of Guests and Maximum Price and People
    Then I Uncheck Latitudes Exclusive Rates
    And I Select Preferred State
    And I Click on Accommodations
    Then I Add Storeroom and Click on Things TO DO
    And User Adds things to do as per his choice
    And I Click on Recommended Button
    And I Validate all details on Recommendations Page