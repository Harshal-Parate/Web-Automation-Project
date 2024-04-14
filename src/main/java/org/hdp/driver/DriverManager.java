package org.hdp.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Objects;

public final class DriverManager {

    private DriverManager() {}

    public static final ThreadLocal<WebDriver> driverRef = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverRef.set(driver);
    }

    public static WebDriver getWebDriver() {
        return driverRef.get();
    }

    public static void unload() {
        driverRef.remove();
    }

    public static void initialization() {
        if (Objects.isNull(getWebDriver())) {
           WebDriver driver = new EdgeDriver();
            //driver = new RemoteWebDriver(new URL("")); --> selenium grid
            setDriver(driver);
        }
    }

    public static void tearDown() {
        if (Objects.nonNull(getWebDriver())) {
            getWebDriver().quit();
            unload();
        }
    }
}