package org.hdp.tests.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;

public class ParametersStepDefs {

    WebDriver driver;

    @Given("^User navigates to login page$")
    public void userNavigatesToLoginPage() {
        driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("User enters valid {string} and {string} creds")
    public void userEntersValidUsernameAndPasswordCreds(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("^User click on login button$")
    public void userClickOnLoginButton() {
        driver.findElement(By.id("submit")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("^Enters inside$")
    public void entersInside() {
        driver.findElement(By.linkText("Log out")).isDisplayed();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("^Quit driver$")
    public void quitDriver() {
        driver.quit();
    }

}