package com.rdb.factories;

import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation")); // Hides Selenium usage
        options.setExperimentalOption("useAutomationExtension", false);

        if (browserName.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic....!!");
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic....!!");
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic....!!");
            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}
