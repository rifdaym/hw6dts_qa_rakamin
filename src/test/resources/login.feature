Feature: User login to the web

  @Fitur1 @Positive @Login
  Scenario Outline: User success login using valid credentials (username:<username>)
    Given User in the login page
    When User input <username> as registered username
    And User input <password> as correct password
    And User click Login button
    Then User will be redirected to homepage with <status> login results

    Examples:
      | username      | password      | status   |
      | standard_user | secret_sauce  | success  |
      | problem_user  | secret_sauce  | success  |

  @Fitur1 @Negative @Login
  Scenario Outline: User failed login using invalid credentials (status user:<status>)
    Given User in the login page
    When User input <username> as registered username
    And User input <password> as incorrect password
    And User click Login button
    Then User view the alert message that status user is <status>

    Examples:
    | username        | password       | status            |
    | standard_user   | secret_sauces  | invalid_password  |
    | locked_out_user | secret_sauce   | locked_user       |


