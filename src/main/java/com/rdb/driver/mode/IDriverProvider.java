package com.rdb.driver.mode;

import com.rdb.driver.browser.IBrowserDriver;
import org.openqa.selenium.WebDriver;

public interface IDriverProvider {

    WebDriver createDriver(IBrowserDriver driver);
}
