package com.rdb.driver.mode;

import com.rdb.driver.browser.IBrowserDriver;
import org.openqa.selenium.WebDriver;

public class LocalDriverProvider implements IDriverProvider {

    @Override
    public WebDriver createDriver(IBrowserDriver driver) {
        try {
            return driver.getDriver();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Local WebDriver", e);
        }

    }
}
