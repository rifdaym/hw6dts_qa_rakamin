Feature: User view the product

  @Fitur2 @Positive @Product
  Scenario: User success view list product page
    Given The user in on the homepage
    When user click All Items Menu
    Then user can view the list product page

  @Fitur3 @Positive @Product
  Scenario: User success view the detail product page
    Given The user in on the homepage
    When user click product
    Then user can view the detail product page

  @Fitur4 @Checkout @Positive
  Scenario: User success checkout with filling complete personal data.
    Given The user in on the homepage
    When the user clicks the Add to Cart button on one of the products
    And User click on icon cart
    And User click Checkout button
    And User input valid first name
    And User input valid last name
    And User input valid postal code
    And User click Continue button
    And User click Finish button
    Then User view the Order Success Page

  @Fitur4 @Checkout @Negative
  Scenario: User failed checkout when filling incomplete personal data
    Given The user in on the homepage
    When the user clicks the Add to Cart button on one of the products
    And User click on icon cart
    And User click Checkout button
    And User skip fill the form, after that click Continue button
    Then User view the alert message that field must be filled out


