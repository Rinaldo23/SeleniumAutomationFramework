package com.rdb.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public final class OrangeHRMHomePage extends BasePage {

    // Locators
    private final By drpdownUserMenu = By.xpath("//li[contains(@class, 'oxd-userdropdown')]");

    private final String menuItems = "//a[text()='%value%']";  // --> Dynamic Xpath

    // Methods

    public OrangeHRMHomePage clickDropdownMenu() {
        click(drpdownUserMenu, "visibe");
        return this;
    }

    public OrangeHRMLoginPage clickFromMenuOptions(String option) {
        WebElement menuOption = DriverManager.getDriver().findElement(By.xpath(menuItems.replace("%value%", option)));
        click(menuOption, "clickable");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        return new OrangeHRMLoginPage();
    }
    /*new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
            .until(driver -> driver.findElement(By.xpath(menuItems.replace("%value%", option))).isEnabled());*/   // Java 8+

    public String getHomePageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
