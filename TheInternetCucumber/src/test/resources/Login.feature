Feature: As an SDET I want to be able to write a test for form authentication
  So that I can test authentication

  Scenario: Successful Login
    Given I am on the homepage
    When I click the Form Authentication link
    Then I should be taken to the login page
    When I navigate back
    Then I am on the homepage

  Scenario: Successful Login Logout
    Given I am on the homepage
    When I Login
    Then I should be taken to the secure area page
    And I should see the secure area alert
    When I Logout
    Then I should be taken to the login page