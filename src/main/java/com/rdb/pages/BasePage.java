package com.rdb.pages;

import com.rdb.driver.DriverManager;
import com.rdb.pages.interactions.InteractionService;

public class BasePage {

    protected final InteractionService interactions;

    protected BasePage(InteractionService interactions) {
        this.interactions = interactions;
    }

    /*public static void waitForPageToLoad() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60))
                .until(driver -> Objects.equals(((JavascriptExecutor) driver).executeScript("return document.readyState"), "complete"));
    }*/

    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public String getPageUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
    }
}
