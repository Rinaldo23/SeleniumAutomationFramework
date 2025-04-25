package com.rdb.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class EdgeBrowserDriver extends BrowserDriverBase {

    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(getOptions());
    }

    @Override
    public WebDriver getDriver(URL remoteAddress) {
        return new RemoteWebDriver(remoteAddress, getOptions());
    }

    private EdgeOptions getOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("test-type", "--disable-extensions");
        edgeOptions.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors", "--incognito");

        if (isEnableHeadlessExecution()) {
            edgeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1280,800");
        }

        if (isRemoteExecution()) {
            edgeOptions.setCapability("browserName", "MicrosoftEdge");
        }

        return edgeOptions;
    }
}
