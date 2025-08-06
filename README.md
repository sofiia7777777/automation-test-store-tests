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

## Framework Features

This test automation framework was enhanced as part of the **Hardcore task** from the WebDriver course.  
The framework includes the following capabilities:

-  **WebDriverManager** for browser driver management.
-  **Page Object** pattern for better test structure and maintainability.
-  **Business objects** representing key domain models used in test flows.
-  **Property files** for environment-specific test data (`dev`, `qa`).
-  **TestNG XML suites** to group and execute Smoke and Regression tests separately.
-  **Automatic screenshots** captured on test failure, with screenshot paths logged.
-  **Flexible test parameters**, such as browser type and target environment, configurable via the command line.

## Logging

The framework uses a logging solution (Log4j2) with the following configuration:

- Logs support multiple levels: `DEBUG`, `INFO`, `ERROR`.
- Output is written both to the **console** and to **daily log files**.
- Each test step and significant event is logged for traceability and debugging.
- Screenshot file paths (in case of failures) are included in the logs.

## How to Run Tests

You can run the tests using Maven with custom parameters for browser, environment, and test suite.  
Use the following command as a template:

```bash
   mvn clean test -Dbrowser=<browser> -Denvironment=<env> -DsuiteXmlFile=<path-to-suite>
```

## Design Patterns Implementation

This project includes implementation of several design patterns aimed at improving code maintainability, scalability, and readability. The following patterns have been applied in different areas of the code:

### Singleton
The Singleton pattern is used to ensure that only one instance of the WebDriver exists throughout the test execution.
- Implemented in the `DriverSingleton` class, which manages the lifecycle of the WebDriver instance.

### Factory Method
The Factory Method pattern is used to abstract the creation of WebDriver objects based on the browser type.
- Implemented in the `BrowserFactory` class, which creates and returns appropriate WebDriver instances such as ChromeDriver or FirefoxDriver.

### Decorator
The Decorator pattern is applied to add logging functionality to UI actions without modifying the original behavior.
- Implemented by defining a `UIActions` interface, a `DefaultUIActions` concrete class, and a `LoggingUIActionsDecorator` that wraps UI actions to provide logging.

### Facade (Bonus)
The Facade pattern simplifies complex interactions involving multiple page objects during the guest checkout process.
- Implemented in the `CheckoutFacade` class, which encapsulates the entire flow from cart to order confirmation into a single method.

---

These patterns have been integrated and are actively used during test execution to demonstrate proper design principles and enhance code quality.
