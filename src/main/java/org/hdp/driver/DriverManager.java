package org.hdp.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class DriverManager {

    private DriverManager() {}

    public static final ThreadLocal<WebDriver> driverRef = new ThreadLocal<>();

    public static DesiredCapabilities capabilities; // make the object for this class

    public static void setDriver(WebDriver driver) {
        driverRef.set(driver);
    }

    public static WebDriver getWebDriver() {
        return driverRef.get();
    }

    public static void unload() {
        driverRef.remove();
    }

    public static void initialization(){
        if (Objects.isNull(getWebDriver())) {

            capabilities = new DesiredCapabilities(); // making an object
            capabilities.setBrowserName("MicrosoftEdge"); // name as per mentioned in terminal
            capabilities.setPlatform(Platform.ANY); // any machine OS

            EdgeOptions options = new EdgeOptions(); // will change according to the browser
            options.merge(capabilities); // merging the capabilities with the edgeOptions

            String hubURL = "http://192.168.1.5:4444/wd/hub"; // url on which the hub is running


            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(hubURL), options); // Dynamic dispatch (upcasting) in Remote WebDriver
                // and in arguments passing the new object of URL class in hub url in it with options of edge
                //
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


            setDriver(driver);


            // normal execution
//            WebDriver driver = new EdgeDriver();
//            setDriver(driver);
        }
    }

    public static void tearDown() {
        if (Objects.nonNull(getWebDriver())) {
            getWebDriver().quit();
            unload();
        }
    }

    /*

    Starting the selenium hub --> download the JAR file from the website
    place the JAR file somewhere
    open the command prompt from the folder

    Type the command to start the HUB --> "java -jar selenium-server-4.19.1.jar hub"

    now download the jars for different browsers and place them in a same folder as Selenium grid jar
    for 1st node
    now hit -->  "java -jar selenium-server-4.19.1.jar standalone"

    for 2nd node
    hit --> "java -jar selenium-server-4.19.1.jar standalone -port 5556"

    for 3rd node
    hit --> "java -jar selenium-server-4.19.1.jar standalone -port 5557"

     */
}