package org.hdp.tests.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefs {
    @Given("^User on login page$")
    public void userOnLoginPage() {
        System.out.println("1");
    }

    @When("^User enters valid creds$")
    public void userEntersValidCreds() {
        System.out.println("2");
    }

    @And("^Click on login button$")
    public void clickOnLoginButton() {
        System.out.println("3");
    }

    @Then("^Moves to dashboard page$")
    public void movesToDashboardPage() {
        System.out.println("4");
    }
}
