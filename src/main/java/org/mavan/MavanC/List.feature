@tag
Feature: User Check login functionality
  I want to use this template for my feature file

  @tag1
  Scenario: User check log in page
    Given User launch facebook application
    And User check url and title
    When User enter username "SwathyArun"
    And User enter password "ArunG"
    And User click login button
    Then User check navigate correct url or not
    And User close the browser

