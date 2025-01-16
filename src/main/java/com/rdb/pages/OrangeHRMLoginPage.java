package com.rdb.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class OrangeHRMLoginPage {

    // Locators
    private final By inputUsername = By.name("username");

    private final By inputPassword = By.xpath("//input[@name='password' and @type='password']");

    private final By btnLogin = By.xpath("//div[contains(@class, 'orangehrm-login-action')]/child::button");

    private final By headerText = By.xpath("//h5[normalize-space()='Login']");

    // Methods
    public void enterUsername(String username) {
        DriverManager.getDriver().findElement(inputUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        DriverManager.getDriver().findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin() {
        DriverManager.getDriver().findElement(btnLogin).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    public boolean getHeader() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(driver -> driver.findElement(headerText).isDisplayed());
        return DriverManager.getDriver().findElement(headerText).isDisplayed();
    }
}
