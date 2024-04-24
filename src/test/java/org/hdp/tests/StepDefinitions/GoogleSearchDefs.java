package org.hdp.tests.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class GoogleSearchDefs {

    WebDriver driver;

    @Given("^Open Google Search page$")
    public void openGoogleSearchPage() {
        driver = new EdgeDriver();
        driver.get("https://www.google.co.in/");

    }

    @When("^Enter details$")
    public void enterDetails() {
        WebElement searchBox = driver.findElement(By.className("gLFyf"));
        searchBox.sendKeys("Maven Repo");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("^Click on search icon$")
    public void clickOnSearchIcon() {
        driver.findElement(By.className("gNO89b")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("^validate the maven repo url$")
    public void validateTheMavenRepoUrl() {
        WebElement link = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        String text = link.getText();
        Assert.assertEquals(text, "Maven Repository: Search/Browse/Explore");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("^Close the driver instance$")
    public void closeTheDriverInstance() {
        driver.quit();
    }
}
