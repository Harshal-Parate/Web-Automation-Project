package org.hdp.pages.pom;

import org.hdp.base.CommonToAllPages;
import org.openqa.selenium.By;

import static org.hdp.driver.DriverManager.driver;
import static org.hdp.utilities.PropertyFileReader.readPropertyFileData;

public class LoginPage extends CommonToAllPages {

    public LoginPage() {
        super();
    }

    // Page Locators

    By username = By.id("login-username");
    By password = By.id("login-password");
    By forgotPassword = By.cssSelector("button[data-qa='juvuwepeyi']");
    By rememberMe = By.xpath("(//div[@class='checkbox-radio']/descendant::span[@class='checkbox-radio-button ng-scope'])[1]");
    By signIn = By.xpath("//span[@data-qa='ezazsuguuy']");
    By signUp = By.xpath("//span[@data-qa='dobevozose']");
    By errorMessage = By.id("js-notification-box-msg");

    // Page Actions

    public String loginToVwoWithInvalidCreds() {
        enterInput(username, readPropertyFileData("Email"));
        enterInput(password, "Harshal@123");
        clickOnElement(signIn);
        return explicitWait(driver, 5, errorMessage).getText();
    }

    public void loginToVwoWithValidCreds() {
     enterInput(username, readPropertyFileData("Email"));
     enterInput(password, readPropertyFileData("Password"));
     clickOnElement(signIn);
    }

    public DashboardPage afterLoginWithValidCreds() {
        return new DashboardPage();
    }
}