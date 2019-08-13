Feature: Add two numbers
  calculate two numbers's sum

  Scenario: Add two positive numbers
    Given two numbers 12 and 16
    When add these two numbers
    Then the result should be 28

    Scenario: Add different type of numbers
      Given the following numbers to test
       |12|13.0|
       |12|-13.0|
       |-12|13.0|
       |0|0|
       |1|0|
