package org.hdp.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.hdp.driver.DriverManager.getWebDriver;
import static org.hdp.utilities.PropertyFileReaderUtility.readPropertyFileData;

public class CommonToAllPages {

    public CommonToAllPages() {
        getWebDriver().get(readPropertyFileData("URL"));
    }

    public void clickOnElement(By by) {
        getWebDriver().findElement(by).click();
    }

    public void enterInput(By by, String input) {
        getWebDriver().findElement(by).sendKeys(input);
    }

    public String getElementText(By by) {
        return getWebDriver().findElement(by).getText();
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