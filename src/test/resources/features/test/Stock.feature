Feature: Stock managment

  Scenario: adding ingredient to a stock
    Given the stock already constains 30 doses of chocolates
    When the manager adds 15 doses of chocolates
    Then the stock should contain 45 doses of chocolates

  Scenario: removing too manry ingredient from a stock
    Given the stock already constains 30 doses of chocolates
    When the manager asks to remove  35 doses of chocolates
    Then the withdrawal is refused
    Then the stock should contain 30 doses of chocolates