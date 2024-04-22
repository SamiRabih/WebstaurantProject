package com.webstaurantStore.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //I've crafted a private constructor to restrict access to this object.
    private Driver() {
    }

    //I've designated the WebDriver as private to restrict access from outside the class.
    // It's also been made static, mirroring this approach for consistency in usage within static methods.
    private static WebDriver driver;// default driver = null

    //I've implemented a reusable utility method that ensures the consistent return of the same driver instance
    public static WebDriver getDriver() {

        if (driver == null) {

            /*
            I'll configure the utility method to read the browser type from a Configuration.properties file,
            ensuring consistency with requirement.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    // I am using selenium version 4
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driver;
    }

    /*
    I've implemented a new method, closeDriver(), which utilizes the .quit() method to gracefully close the browser.
     After closing the browser, it resets the driver value to null, ensuring proper cleanup and resource management.
     */

    public static void closeDriver() {
        if (driver != null) {

            driver.quit();
            /*
           We assign the value back to null so that the "singleton" can create a new instance if needed in the future
             */
            driver = null;
        }
    }
}
