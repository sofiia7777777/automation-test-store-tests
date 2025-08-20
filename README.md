# Project Overview

This project extends the code from branch `module-10-improvements` by integrating Cucumber-JVM for BDD-style test automation. It includes Gherkin scenarios with `Scenario Outline`, `Examples`, and `Background` keywords. Step classes use **PicoContainer** for dependency management across scenarios.


## Features

- **Scenario Outline & Examples**  
  Allows parametrized testing using `Scenario Outline` and `Examples:` in Gherkin feature files.

- **Background Steps**  
  Recurrent preconditions are implemented using the `Background` keyword to reduce duplication in feature files.

- **Step Definition Flexibility**  
  Uses **regular expressions** in step definitions to capture dynamic test data efficiently.

- **Common Step Definitions**  
  Implements a `CommonStepDefinitions` class to share reusable steps across multiple scenarios.

- **Dependency Injection with PicoContainer**  
  Step classes use **PicoContainer** to manage dependencies and maintain shared state safely without relying on static fields.