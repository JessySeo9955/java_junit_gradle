Feature: User login functionality

  Scenario: Valid user login
    Given I have a valid username and password
    When I submit the login form
    Then I should be logged in successfully