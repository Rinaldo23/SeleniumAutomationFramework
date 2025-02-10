package com.rdb.pages.amazonpages;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class AmazonHomePage extends BasePage {

    /* Older way of using @FindBy in Selenium 2 & early Selenium 3 - It is Deprecated */
    /* @FindBy(how = How.ID, using = "nav-logo-sprites")
    private WebElement amazonLogo; */

    @FindBy(id = "nav-logo-sprites")
    private WebElement amazonLogo;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu' and @role='button']")
    private WebElement btnHamburgerMenu;

    public AmazonHomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    /* ============================================================================================================== */

    public WebElement getAmazonHeaderLogo() {
        return amazonLogo;
    }

    public AmazonHamburgerMenuPage openAllCategoriesHamburgerMenu() {
//        if (!btnHamburgerMenu.isDisplayed()) {
//            refreshPage();
//        }
        click(btnHamburgerMenu, "All Categories Menu", WaitStrategy.CLICKABLE);
        return new AmazonHamburgerMenuPage();
    }
}

