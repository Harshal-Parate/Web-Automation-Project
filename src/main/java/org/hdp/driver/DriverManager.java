package org.hdp.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Objects;

public final class DriverManager {

    private DriverManager() {}

    private static final ThreadLocal<WebDriver> driverRef = new ThreadLocal<>();
    private static WebDriver driver;

    public static void setDriverRef(WebDriver driver) {
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
            //driver = new RemoteWebDriver(new URL("")); --> selenium grid
//            EdgeOptions ed = new EdgeOptions();
//            ed.addArguments("-headless");
            driver = new EdgeDriver();
            setDriverRef(driver);
        }
    }

    public static void tearDown() {
        if (Objects.nonNull(getWebDriver())) {
            driver.quit();
            unload();
        }
    }
}