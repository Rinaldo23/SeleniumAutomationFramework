package com.rdb.pages;

import com.rdb.pages.interactions.InteractionServiceImpl;
import org.openqa.selenium.By;

public final class HomePage extends BasePage {

    /* Older way of using @FindBy in Selenium 2 & early Selenium 3 - It is Deprecated */
    /* @FindBy(how = How.ID, using = "nav-logo-sprites")
    private WebElement amazonLogo; */

    /* @FindBy(id = "nav-logo-sprites")
    private WebElement amazonLogo;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu' and @role='button']")
    private WebElement btnHamburgerMenu; */

    private final By amazonLogo = By.id("nav-logo-sprites");

    private final By btnHamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu' and @role='button']");

    /* public HomePage(InteractionService interactions) {
        super(interactions);
        PageFactory.initElements(DriverManager.getDriver(), this);
    } */

    public HomePage(InteractionServiceImpl interactions) {
        super(interactions);
    }

    public boolean isAmazonHeaderLogoPresent() {
        return interactions.checkIfElementsExistsInDOM(amazonLogo, "amazonLogo", 10);
    }

    public HomePage openAllCategoriesHamburgerMenu() {
        interactions.click(btnHamburgerMenu, "All Categories Menu", 10);
        interactions.waitForAjaxCalls(10);
        return this;
    }

    /* public boolean isAmazonHeaderLogoPresent() {
        return interactions.isElementPresent(amazonLogo, WaitStrategy.VISIBLE);
    }

    public HomePage openAllCategoriesHamburgerMenu() {
        interactions.click(btnHamburgerMenu, "All Categories Menu", WaitStrategy.CLICKABLE);
        interactions.waitForAjaxCalls(10);
        return this;
    } */
}

