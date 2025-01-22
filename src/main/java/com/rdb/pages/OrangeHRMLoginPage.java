package com.rdb.pages;

import com.rdb.enums.WaitStrategy;
import com.rdb.reports.ExtentReport;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    // Locators
    private final By inputUsername = By.name("username");
    private final By inputPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By btnLogin = By.xpath("//div[contains(@class, 'orangehrm-login-action')]/child::button");

    // Methods
    public OrangeHRMLoginPage enterUsername(String username) {
        setTextBoxValue(inputUsername, username, WaitStrategy.CLICKABLE);
        ExtentReport.test.pass("Text box value set to " + username);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        setTextBoxValue(inputPassword, password, WaitStrategy.VISIBLE);
        ExtentReport.test.pass("Text box value set to " + password);
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(btnLogin, WaitStrategy.CLICKABLE);
        ExtentReport.test.pass("Clicked on " + btnLogin + " button");
        return new OrangeHRMHomePage();
    }
}
