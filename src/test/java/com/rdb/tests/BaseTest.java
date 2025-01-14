package com.rdb.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.rdb.constants.FrameworkConstants.getChromeDriverPath;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
