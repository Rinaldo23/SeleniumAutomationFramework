package com.rdb.driver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

import static com.rdb.constants.FrameworkConstants.getChromeDriverPath;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());

//            WebDriver driver = new ChromeDriver();
//            DriverManager.setDriver(driver);

            DriverManager.setDriver(new ChromeDriver());

            DriverManager.getDriver().get("https://www.google.co.in/");
            DriverManager.getDriver().manage().window().maximize();

            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
//            driver = null;
            DriverManager.unload();
        }
    }

}
