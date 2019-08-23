@tag
Feature: User check login functionality
  

  @tag1
  Scenario: User check login page
    Given Use launches the facebook page
    And User check the current url and title page
    When User enter username
    And User enter password
    And User click login button
    Then User check the navigate url
    And user close the broser

