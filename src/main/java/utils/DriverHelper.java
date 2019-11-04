package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverHelper {
    public static WebDriver getDriver() {
        Properties runProp = PropertiesFileReader.readPropFile("run");
        Properties driveProp = PropertiesFileReader.readPropFile(runProp.getProperty("driverType"));
        System.setProperty(driveProp.getProperty("propertyName"), System.getProperty("user.dir") + driveProp.getProperty("driverPath"));

        WebDriver driver = null;
            switch (runProp.getProperty("driverType")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
            }
        return driver;
    }
}
