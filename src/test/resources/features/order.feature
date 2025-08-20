Feature: Checkout process

  Background:
    Given I am on the home page

  @regression
  Scenario Outline: Guest user can purchase product successfully
    When I select category "<category>" and subcategory "<subCategory>"
    And I select the product "<productName>"
    And I add the product to the cart
    And I proceed to checkout as guest
    And I provide guest information
    And I confirm the order
    Then I should see the order confirmation message "Your order has been successfully processed!"

    Examples:
      | category  | subCategory | productName                |
      | BOOKS     | Paperback   | ALLEGIANT BY VERONICA ROTH |
      | HAIR CARE | Conditioner | SEAWEED CONDITIONER        |