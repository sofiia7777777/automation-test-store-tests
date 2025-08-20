Feature: Add product to cart

  Background:
    Given I am on the home page

  @smoke @regression
  Scenario Outline: Add a product to the cart successfully
    When I select category "<category>" and subcategory "<subCategory>"
    And I select the product "<productName>"
    And I add the product to the cart
    Then I should see the product "<expectedProductName>" in my cart
    And the product price should be <expectedProductPrice>

    Examples:
      | category  | subCategory | productName                | expectedProductName           | expectedProductPrice |
      | BOOKS     | Paperback   | ALLEGIANT BY VERONICA ROTH | Allegiant by Veronica Roth    | $7.99                |
      | HAIR CARE | Conditioner | SEAWEED CONDITIONER        | Seaweed Conditioner           | $19.00               |
      | FRAGRANCE | Women       | GUCCI GUILTY               | Gucci Guilty                  | $105.00              |

