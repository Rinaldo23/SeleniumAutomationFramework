package com.rdb.driver.browser;

import org.openqa.selenium.WebDriver;

import java.net.URL;

public interface IBrowserDriver {

    boolean isEnableHeadlessExecution();

    void setEnableHeadlessExecution(boolean enableHeadlessExecution);

    boolean isRemoteExecution();

    void setRemoteExecution(boolean setRemoteExecutionMode);

    WebDriver getDriver();

    WebDriver getDriver(URL remoteAddress);

}
