package org.hdp.tests.basetest;

import org.hdp.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    public CommonToAllTest() {}

    @BeforeMethod
    public void setupBrowser() {
        DriverManager.initialization();
    }

    @AfterMethod
    public void quittingSession() {
        DriverManager.tearDown();
    }
}