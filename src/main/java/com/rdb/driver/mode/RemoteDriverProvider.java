package com.rdb.driver.mode;

import com.rdb.driver.browser.IBrowserDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RemoteDriverProvider implements IDriverProvider {

    private static final String REMOTE_URL = "http://localhost:4444/wd/hub";

    @Override
    public WebDriver createDriver(IBrowserDriver driver) {
        try {
            URL gridUrl = new URI(REMOTE_URL).toURL();
            return driver.getDriver(gridUrl); // You could also make this more dynamic
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException("Failed to create Remote WebDriver", e);
        }
    }
}
