package org.hdp.pages.pom;

import org.hdp.base.CommonToAllPages;
import org.openqa.selenium.By;
import static org.hdp.driver.DriverManager.getWebDriver;

public class DashboardPage extends CommonToAllPages {

    public DashboardPage() {
        super();
    }

    By usernameBox = By.xpath("//span[@data-qa='lufexuloga']");

    public String getUsernameFromDashBoardBox() {
        explicitWait(getWebDriver(), 10, usernameBox);
        return getElementText(usernameBox);
    }
}