@tag
Feature: User Check login functionality

  @tag1
  Scenario: User check log in page
    Given User launch facebook application
    And User check the url and title of page
    When User enter username and password
      | username   | password |
      | SwathyArun | Arun     |
    And User enter firstname,lastname and phoneno
      | firstname | lastname | phoneno   |
      | swathy    | Arun     | 123456789 |
      | Swathy    | arun     |   2345697 |
    And user click register button
    Then user check navigate url
    And User closes the browser
