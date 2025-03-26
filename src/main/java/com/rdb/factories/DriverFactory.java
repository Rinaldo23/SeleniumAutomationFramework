package com.rdb.factories;

import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        chromeOptions.setExperimentalOption("excludeSwitches", List.of("enable-automation")); // Hides Selenium usage
        chromeOptions.setExperimentalOption("useAutomationExtension", false);

        if (browserName.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic - Chrome!!");
                chromeOptions.setCapability("browserName", browserName);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic - Firefox!!");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("browserName", browserName);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else if (browserName.equalsIgnoreCase("MicrosoftEdge")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic - MicrosoftEdge!!");

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("browserName", browserName);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}
