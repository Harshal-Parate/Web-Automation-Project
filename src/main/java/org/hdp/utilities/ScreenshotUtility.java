package org.hdp.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import static org.hdp.utilities.DateTimeUtility.currentDateTime;

public final class ScreenshotUtility {

    private ScreenshotUtility() {}

    public static void takeScreenShot(WebDriver driver, String name) {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("/Users/harshalparate/Downloads/SDET Master/Projects/WebAutomation/src/test/resources/Screenshots/"+name+"-"+currentDateTime()+".jpeg");
        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}