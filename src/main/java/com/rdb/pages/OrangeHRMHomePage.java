package com.rdb.pages;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class OrangeHRMHomePage extends BasePage {

    // Locators
    private final By drpdownMenu = By.xpath("//li[contains(@class, 'oxd-userdropdown')]");

    private final String drpdownMenuItems = "//a[text()='%value%']";  // --> Dynamic Xpath

    // Methods

    public OrangeHRMHomePage clickDropdownMenu() {
        click(drpdownMenu, "Profile Dropdown Menu", WaitStrategy.VISIBLE);
        return this;
    }

    public OrangeHRMLoginPage clickFromMenuOptions(String option) {
        WebElement menuOption = DriverManager.getDriver().findElement(By.xpath(drpdownMenuItems.replace("%value%", option)));
        click(menuOption, option, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();
    }
    /*new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
            .until(driver -> driver.findElement(By.xpath(menuItems.replace("%value%", option))).isEnabled());*/   // Java 8+
}
