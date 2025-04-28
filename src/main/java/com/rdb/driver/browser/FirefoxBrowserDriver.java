package com.rdb.driver.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.logging.Level;

public class FirefoxBrowserDriver extends BrowserDriverBase {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new FirefoxDriver(getOptions());
    }

    @Override
    public WebDriver getDriver(URL remoteAddress) {
        return new RemoteWebDriver(remoteAddress, getOptions());
    }

    private FirefoxOptions getOptions() {
        // Suppress geckodriver and Firefox internal logs
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        // Set Firefox logging level to "OFF" to suppress logs
        firefoxOptions.addPreference("webdriver.log.file", "/dev/null"); // For Linux/macOS
        // For Windows
        firefoxOptions.addPreference("webdriver.log.file", "NUL");
        // Set log level to severe (optional, based on your needs)
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.fromLevel(Level.SEVERE));

        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("test-type", "--disable-extensions");
        firefoxOptions.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors", "--incognito");

        if (isEnableHeadlessExecution()) {
            firefoxOptions.addArguments("--headless", "--disable-gpu", "--window-size=1280,800");
        }

        return firefoxOptions;
    }

}
