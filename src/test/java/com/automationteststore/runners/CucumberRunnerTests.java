package com.automationteststore.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automationteststore.stepdefinitions", "com.automationteststore.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@smoke or @regression"
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
