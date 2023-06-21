Feature: Get title and author from books
  As user
  I want to get the tittel and author from books
  Scenario:
    Given I send a GET request to fetch book information
    When the response should have a status code of 200
    Then the response should contain the title and author of the book