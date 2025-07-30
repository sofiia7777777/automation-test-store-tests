# Automation Test Store – UI Test Suite

This project contains automated UI tests for the e-commerce website https://automationteststore.com.  
The tests are implemented using Java, Selenium WebDriver, and TestNG, following the Page Object Model (POM) design pattern with inheritance.

## Test Scenarios

### Scenario 1: Verify that an existing user can successfully log in

**Precondition:**  
A user account with valid credentials already exists.

**Steps:**
1. Open the website.
2. Click on the "Login or Register" button.
3. Enter a valid username: `James`.
4. Enter a valid password: `123456`.
5. Click the "Login" button.
6. Verify that the user is logged in:
   - The "Login or Register" link changes to point to the user's account page (`account/account`).
   - The text "Welcome back James" is displayed in the header.

### Scenario 2: Verify that the user can add a product to the cart

**Steps:**
1. Open the website.
2. Navigate to the "BOOKS" category.
3. Select the "Paperback" subcategory.
4. Click on the product "ALLEGIANT BY VERONICA ROTH".
5. Click the "Add to Cart" button.
6. Open the shopping cart.
7. Verify that the product appears in the cart:
    - The product title is "Allegiant by Veronica Roth".
    - The product price is "$7.99".

### Scenario 3: Verify product purchase

**Steps:**
1. Open the website.
2. Navigate to the "BOOKS" category.
3. Select the "Paperback" subcategory.
4. Click on the product "ALLEGIANT BY VERONICA ROTH".
5. Add the product to the cart.
6. Open the cart and click the "Checkout" button.
7. Select "Guest Checkout" and continue.
8. Fill in the guest checkout form with valid user details.
9. Continue to the confirmation page and click "Confirm Order".
10. Verify that the confirmation message "Your order has been successfully processed!" is displayed.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Page Object Model (POM)
- Maven