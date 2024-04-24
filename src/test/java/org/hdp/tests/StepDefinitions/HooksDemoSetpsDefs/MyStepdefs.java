package org.hdp.tests.StepDefinitions.HooksDemoSetpsDefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyStepdefs {

    WebDriver driver;


    // works like beforeMethod annotation --> Hook --> will execute before every scenario
    @Before
    public void browserSetup() {
        driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    /*

    @BeforeStep(order=1)  --> works like priority
    public void beforeStep() {
        System.out.println("Inside before step");
    }

    @BeforeStep("@Smoke")
    public void beforeStep() {
    System.out.println("Inside before step");
    }

    @BeforeStep("@Smoke", order=1)
    public void beforeStep() {
    System.out.println("Inside before step");
    }

     */

    @BeforeStep("@Smoke")
    public void beforeStep() {
        System.out.println("Inside before step");
    }

    @Given("User is on login page")
    public void userIsOnLoginPage() {
    }

    @AfterStep
    public void afterStep() {
        System.out.println("Inside After step");
    }

    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
    }

    @Then("Navigate to dashboard page")
    public void navigateToDashboardPage() {
    }

    // works like AfterMethod annotation --> Hook --> will execute after every scenario
    @After
    public void tearDown() {
        driver.quit();
    }

}