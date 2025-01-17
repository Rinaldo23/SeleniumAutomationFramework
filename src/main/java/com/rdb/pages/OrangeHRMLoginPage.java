package com.rdb.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class OrangeHRMLoginPage extends BasePage {

    // Locators
    private final By inputUsername = By.name("username");
    private final By inputPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By btnLogin = By.xpath("//div[contains(@class, 'orangehrm-login-action')]/child::button");
    private final By headerText = By.xpath("//h5[normalize-space()='Login']");

    // Methods
    public OrangeHRMLoginPage enterUsername(String username) {
        setTextBoxValue(inputUsername, username, "visible");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        setTextBoxValue(inputPassword, password, "clickable");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(btnLogin, "clickable");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        return new OrangeHRMHomePage();
    }

    public boolean getLoginPageHeader() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(driver -> driver.findElement(headerText).isDisplayed());
        return DriverManager.getDriver().findElement(headerText).isDisplayed();
    }
}
