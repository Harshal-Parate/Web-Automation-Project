package org.hdp.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public final class DriverManager {

    private DriverManager() {}

    public static WebDriver driver;

    public static void initialization() {
        if(driver == null) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("-headless");
            driver = new EdgeDriver(options);
        }
    }

    public static void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}