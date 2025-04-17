package com.rdb.interactions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.rdb.factories.ExplicitWaitFactory.performExplicitWait;

public final class Interactions {

    private boolean elementIsInteractable(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    public void click(WebElement element, String elementName, WaitStrategy waitStrategy) {
        WebElement webElement = performExplicitWait(element, waitStrategy);
        if (elementIsInteractable(webElement)) {
            webElement.click();
        }
        ExtentLogger.pass("Successfully clicked on " + elementName, false);
    }

    public void click(By locator, String elementName, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        click(element, elementName, waitStrategy);
    }

    public void mouseHoverAndClick(WebElement element, String elementName, WaitStrategy waitStrategy) {
        WebElement webElement = performExplicitWait(element, waitStrategy);
        new Actions(DriverManager.getDriver())
                .scrollToElement(webElement)
                .moveToElement(webElement)
                .click()
                .perform();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        ExtentLogger.pass("Successfully clicked on " + elementName + " using Actions Class", false);
    }

    public void mouseHoverAndClick(By locator, String elementName, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        mouseHoverAndClick(element, elementName, waitStrategy);
    }

    public void setTextBoxValue(WebElement element, String text, WaitStrategy waitStrategy) {
        WebElement webElement = performExplicitWait(element, waitStrategy);
        if (elementIsInteractable(webElement)) {
            webElement.sendKeys(text);
        }
        ExtentLogger.pass("Text box value set to " + text, true);
    }

    public void setTextBoxValue(By locator, String text, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        setTextBoxValue(element, text, waitStrategy);
    }

    public boolean isElementPresent(WebElement element, WaitStrategy waitStrategy) {
        return performExplicitWait(element, waitStrategy).isDisplayed();
    }

    public boolean isElementPresent(By locator, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        return isElementPresent(element, waitStrategy);
    }

}
