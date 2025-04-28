package com.rdb.driver.browser;

import org.openqa.selenium.WebDriver;

import java.net.URL;

public interface IBrowserDriver {

    boolean isEnableHeadlessExecution();

    void setEnableHeadlessExecution(boolean enableHeadlessExecution);

    WebDriver getDriver();

    WebDriver getDriver(URL remoteAddress);

}
