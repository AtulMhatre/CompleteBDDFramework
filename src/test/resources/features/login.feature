Feature: Verify login module

  Background:
    Given user is on login page

  @Sanity
  Scenario: verify valid login with valid credentials
    Given  User enter valid Username and Password
    When user click on login button
    Then User Should be on registarion page


  Scenario Outline: Verify invalid username and password
    Given user enter invalid "<Username>" and "<Password>"
    When user click on login button
    Then user should see error msg "<Error_msg>"

    Examples:
      | Username          | Password        | error_msg                                             |
      | invalid@gmail.com | 123456          | Warning: No match for E-Mail Address and/or Password. |
      | valid@gmail.com   | invalidpassword | Warning: No match for E-Mail Address and/or Password. |
      | abccc             | abccc           | Warning: No match for E-Mail Address and/or Password. |




