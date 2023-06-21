Feature: Login functonality
  As user
  I want to login
  Scenario:
    Given The user is in book list page
    When The user clicks in log in button
    And The user is redirected to login page
    And The user introduces the user name in username input
    And The user introduces the password in password input
    And The user clicks in log in button in log in page
    Then The user is logged