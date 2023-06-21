Feature: Search functionality for the books list
  As a user
  I want to be able to search on the book catalog
  so that i can find the books i am looking for
  Scenario Outline: Refresh books list
    Given The user is in book list page
    And The Input search box is displayed
    And The input search box button is displayed and clickable
    And The List books is displayed
    When The user introduces "<text>" in text input
    Then The books list refresh and show "<number>" books that contains the text
    Examples:
      | text |number|
      | javascript |4 |
      | pocket|1|
      | cz|0 |

