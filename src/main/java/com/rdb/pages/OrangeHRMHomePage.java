package com.rdb.pages;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class OrangeHRMHomePage extends BasePage {

    // Locators
    private final By drpdownUserMenu = By.xpath("//li[contains(@class, 'oxd-userdropdown')]");

    private final String menuItems = "//a[text()='%value%']";  // --> Dynamic Xpath

    // Methods

    public OrangeHRMHomePage clickDropdownMenu() {
        click(drpdownUserMenu, WaitStrategy.VISIBLE);
        ExtentLogger.pass("Clicked on " + drpdownUserMenu + " button");
        return this;
    }

    public OrangeHRMLoginPage clickFromMenuOptions(String option) {
        WebElement menuOption = DriverManager.getDriver().findElement(By.xpath(menuItems.replace("%value%", option)));
        click(menuOption, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Clicked on " + option + " menuOption.");
        return new OrangeHRMLoginPage();
    }
    /*new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
            .until(driver -> driver.findElement(By.xpath(menuItems.replace("%value%", option))).isEnabled());*/   // Java 8+
}
