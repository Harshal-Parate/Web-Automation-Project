package org.hdp.tests.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hdp.base.CommonToAllPages;
import org.hdp.driver.DriverManager;
import org.hdp.pages.pom.LoginPage;

import java.sql.SQLOutput;

public class VwoLoginStepDefinitations {

    @Given("User navigates to login page of VWO.")
    public void userNavigatesToLoginPageOfVWO() {
        DriverManager.initialization();
        DriverManager.getWebDriver().get("https://app.vwo.com/#/login");
    }

    @When("User enters invalid {string} and {string}.")
    public void userEntersInvalidAnd(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToVwoWithInvalidCreds(username, password);
    }

    @And("User click on login button.")
    public void userClickOnLoginButton() {
        System.out.println("User clicked on login button");
    }

    @Then("User should get error message.")
    public void userShouldGetErrorMessage() {
        LoginPage loginPage = new LoginPage();
        String errorMsg = loginPage.explicitWait
                (DriverManager.getWebDriver(), 5, loginPage.getErrorMessage()).getText();
        System.out.println(errorMsg);
    }

    @And("Session closed")
    public void sessionClosed() {
        DriverManager.tearDown();
    }
}
