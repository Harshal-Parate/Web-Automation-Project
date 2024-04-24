package org.hdp.tests.StepDefinitions.BackgroundDemoStepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundStepsDefs {

    @Given("User is on a login page")
    public void userIsOnALoginPage() {
        System.out.println("Back1");
    }

    @When("enter username and a password")
    public void enterUsernameAndAPassword() {
        System.out.println("Back2");
    }

    @And("clicks on a login button")
    public void clicksOnALoginButton() {
        System.out.println("Back3");
    }

    @Then("user is navigated to a home page")
    public void userIsNavigatedToAHomePage() {
        System.out.println("Back4");
    }

    @When("User click on a welcome link")
    public void userClickOnAWelcomeLink() {
    }

    @Then("Logout is displayed.")
    public void logoutIsDisplayed() {
    }

    @When("User click on a dashboard link")
    public void userClickOnADashboardLink() {
    }

    @Then("Quick launch a tool is displayed")
    public void quickLaunchAToolIsDisplayed() {
    }
}