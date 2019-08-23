@tag
Feature: User Check login functionality
 

  @tag1
  Scenario: User check log in page
    Given User launch facebook application
    And User check the url and title of page
    When User enter username and password
    |SwathyArun|ArunG|
    |Swathy|Arun|
    And User enter firstname,lastname and phoneno
    |Swathy|Arun|1234569870|
    |SwathyArun|G|3264121232|
    And user click register button
    Then user check navigate url
    And User closes the browser
