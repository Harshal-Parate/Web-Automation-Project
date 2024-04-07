package org.hdp.tests;

import org.hdp.pages.pom.DashboardPage;
import org.hdp.pages.pom.LoginPage;
import org.hdp.tests.basetest.CommonToAllTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VwoLoginTestsPage extends CommonToAllTest {

    @Test
    public void loginTestWithInvalidCreds() {
        LoginPage loginPage = new LoginPage();
        String actualMessage = loginPage.loginToVwoWithInvalidCreds();
        Assert.assertEquals(actualMessage, "Your email, password, IP address or location did not match");
    }

    @Test
    public void loginTestWithValidCreds() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToVwoWithValidCreds();
        DashboardPage dashboardPage = loginPage.afterLoginWithValidCreds();
        String usernameFromDashBoardBox = dashboardPage.getUsernameFromDashBoardBox();
        Assert.assertEquals(usernameFromDashBoardBox, "Harsh Parate");
    }
}