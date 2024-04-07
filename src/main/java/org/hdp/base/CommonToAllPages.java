package org.hdp.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.hdp.driver.DriverManager.driver;
import static org.hdp.utilities.PropertyFileReader.readPropertyFileData;

public class CommonToAllPages {

    public CommonToAllPages() {
        driver.get(readPropertyFileData("URL"));
    }

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void enterInput(By by, String input) {
        driver.findElement(by).sendKeys(input);
    }

    public String getElementText(By by) {
        return driver.findElement(by).getText();
    }

    public WebElement explicitWait(WebDriver driver, int waitTimeInSeconds, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement implicitWait(WebDriver driver, int waitTimeInSeconds, int waitTimeInMillis , By by) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(waitTimeInSeconds))
                .pollingEvery(Duration.ofMillis(waitTimeInMillis))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(by));
    }
}