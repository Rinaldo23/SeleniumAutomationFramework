package com.rdb.driver.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;

public class ChromeBrowserDriver extends BrowserDriverBase {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getOptions());
    }

    @Override
    public WebDriver getDriver(URL remoteAddress) {
        return new RemoteWebDriver(remoteAddress, getOptions());
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("test-type", "--disable-extensions");
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors", "--incognito");

        if (isEnableHeadlessExecution()) {
            options.addArguments("--headless", "--disable-gpu", "--window-size=1280,800");
        }

        if (isRemoteExecution()) {
            options.setCapability("browserName", "chrome");
        }

        return options;
    }
}
