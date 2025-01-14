package com.rdb.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static com.rdb.constants.FrameworkConstants.getChromeDriverPath;

public class Driver {

    public static WebDriver driver;

    public static void initDriver() {
        if (Objects.isNull(driver)) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
            driver.get("https://www.google.co.in/");
            driver.manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }

}
