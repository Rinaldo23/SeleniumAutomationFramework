package com.rdb.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class OrangeHRMHomePage {

    // Locators
    private final By drpdownUserMenu = By.xpath("//li[contains(@class, 'oxd-userdropdown')]");

    private String menuItems = "//a[text()='%value%']";  // --> Dynamic Xpath

    // Methods

    public OrangeHRMHomePage clickDropdownMenu() {
        DriverManager.getDriver().findElement(drpdownUserMenu).click();
        return this;
    }

    public OrangeHRMLoginPage clickFromMenuoptions(String option) {
        WebElement element = DriverManager.getDriver().findElement(By.xpath(menuItems.replace("%value%", option)));
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        return new OrangeHRMLoginPage();
    }
    /*new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
            .until(driver -> driver.findElement(By.xpath(menuItems.replace("%value%", option))).isEnabled());*/   // Java 8+

    public String getHomePageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
