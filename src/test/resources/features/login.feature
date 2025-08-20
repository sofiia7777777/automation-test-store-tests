Feature: Login functionality

  Background:
    Given I am on the home page

  @smoke @regression
  Scenario: Successful login with valid credentials
    When I navigate to the login page
    And I login with valid credentials
    Then I should see a welcome message with my username
    And I should be logged in



