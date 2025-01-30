package com.rdb.pages;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.rdb.factories.ExplicitWaitFactory.performExplicitWait;

public class BasePage {

    protected BasePage() {
    }

    /*public static void waitForPageToLoad() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60))
                .until(driver -> Objects.equals(((JavascriptExecutor) driver).executeScript("return document.readyState"), "complete"));
    }*/

    private boolean elementIsInteractable(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    protected void click(WebElement element, String elementName, WaitStrategy waitStrategy) {
        WebElement webElement = performExplicitWait(element, waitStrategy);
        if (elementIsInteractable(webElement)) {
            webElement.click();
        }
        ExtentLogger.pass("Successfully clicked on " + elementName, true);
    }

    protected void click(By locator, String elementName, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        click(element, elementName, waitStrategy);
    }

    protected void setTextBoxValue(WebElement element, String text, WaitStrategy waitStrategy) {
        WebElement webElement = performExplicitWait(element, waitStrategy);
        if (elementIsInteractable(webElement)) {
            webElement.sendKeys(text);
        }
        ExtentLogger.pass("Text box value set to " + text, true);
    }

    protected void setTextBoxValue(By locator, String text, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        setTextBoxValue(element, text, waitStrategy);
    }

    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public String getPageUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }
}
