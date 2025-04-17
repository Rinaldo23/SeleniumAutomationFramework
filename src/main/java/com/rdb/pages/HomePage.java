package com.rdb.pages;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.interactions.Interactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class HomePage extends BasePage {

    /* Older way of using @FindBy in Selenium 2 & early Selenium 3 - It is Deprecated */
    /* @FindBy(how = How.ID, using = "nav-logo-sprites")
    private WebElement amazonLogo; */

    @FindBy(id = "nav-logo-sprites")
    private WebElement amazonLogo;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu' and @role='button']")
    private WebElement btnHamburgerMenu;

    public HomePage(Interactions interactions) {
        super(interactions);
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    /* ============================================================================================================== */

    public WebElement getAmazonHeaderLogo() {
        return amazonLogo;
    }

    public HamburgerMenuPage openAllCategoriesHamburgerMenu() {
//        if (!btnHamburgerMenu.isDisplayed()) {
//            refreshPage();
//        }
        interactions.click(btnHamburgerMenu, "All Categories Menu", WaitStrategy.CLICKABLE);
        return new HamburgerMenuPage(interactions);
    }
}

