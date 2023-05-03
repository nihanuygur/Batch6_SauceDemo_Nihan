Feature: Login and E2E Test

  @wip
  Scenario: E2E Test
    Given The user is on the login page
    When The user logs in using "standard_user" and "secret_sauce" credentials
    Then The user should be able to login and see "Products" header
    And  The user should be able to sort the products "Price (high to low)"
    And The user clicks cheapest as "cheapest" and second costliest as "2" products
    And  The user opens basket
    And  The user clicks checkout
    And  The user enters details "Mike" "Smith" "HA67NU" and finish the purchase
    Then The user verify that Total Price is $"Total: $41.02"
    And The user clicks finish button
    And The user should be able to see confirmation message "Thank you for your order!"
