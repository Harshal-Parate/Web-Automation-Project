package org.hdp.tests;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.hdp.pages.pom.DashboardPage;
import org.hdp.pages.pom.LoginPage;
import org.hdp.tests.basetest.CommonToAllTest;
import org.hdp.utilities.ExcelReaderUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VwoLoginTestsPage extends CommonToAllTest {

    @Test
    @Description("Invalid Creds")
    public void loginTestWithInvalidCreds() {
        LoginPage loginPage = new LoginPage();
        String actualMessage = loginPage.loginToVwoWithInvalidCreds();
        Assert.assertEquals(actualMessage, " email, password, IP address or location did not match");
    }

    @Test
    @Description("valid Creds")
    public void loginTestWithValidCreds() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToVwoWithValidCreds();
        DashboardPage dashboardPage = loginPage.afterLoginWithValidCreds();
        String usernameFromDashBoardBox = dashboardPage.getUsernameFromDashBoardBox();
        Assert.assertEquals(usernameFromDashBoardBox, "Harsh Parate");
    }


    // Test with Data Provider
    @Test(dataProvider = "getData")
    @Description("Invalid Creds with data provider")
    public void loginTestWithInvalidCredsDataProvider(String email, String password) {
        LoginPage loginPage = new LoginPage();
        String actualMessage = loginPage.loginToVwoWithInvalidCreds(email, password);
        Assert.assertEquals(actualMessage, "Your email, password, IP address or location did not match");
    }



    @DataProvider(name = "getData")
    public Object[][] getData() {
        return ExcelReaderUtility.getData();
    }
}