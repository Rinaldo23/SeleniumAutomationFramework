package com.rdb.interactions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import com.rdb.enums.ConfigProperties;
import com.rdb.enums.WaitStrategy;
import com.rdb.reports.ExtentLogger;
import com.rdb.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

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

    public void mouseHover(By locator, String elementName, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        mouseHover(element, elementName, waitStrategy);
    }

    public void mouseHover(WebElement element, String elementName, WaitStrategy waitStrategy) {
        WebElement webElement = performExplicitWait(element, waitStrategy);
        new Actions(DriverManager.getDriver())
                .scrollToElement(webElement)
                .moveToElement(webElement)
                .perform();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        ExtentLogger.pass("Successfully hovered on " + elementName + " using Actions Class", false);
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
        ExtentLogger.pass("Text box value set to " + text, false);
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

    public List<WebElement> getListOfELements(By locator, WaitStrategy waitStrategy) {
        performExplicitWait(DriverManager.getDriver().findElement(locator), waitStrategy);
        return DriverManager.getDriver().findElements(locator);
    }

    /*
    * What this handles:
        - If jQuery is not present, it won’t crash (returns true and skips).
        - If jQuery is present, it waits until all active AJAX calls are done (jQuery.active == 0).
    */
    public void waitForAjaxCalls(int maxWaitTime) {
        int waitTime = (maxWaitTime == 0) ? Integer.parseInt(PropertyUtils.getValue(ConfigProperties.SELENIUMCOMMANDTIMEOUT)) : maxWaitTime;

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime));
        wait.until(driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                return (Boolean) js.executeScript("return window.jQuery === undefined || jQuery.active === 0;");
            } catch (Exception e) {
                // Optional: log warning if needed
                return true; // Fail-safe: proceed if jQuery not available
            }
        });
    }

    public void waitForPageLoad(int maxWaitTimeInSeconds) {
        int waitTime = (maxWaitTimeInSeconds == 0)
                ? Integer.parseInt(PropertyUtils.getValue(ConfigProperties.PAGELOADWAITTIME))
                : maxWaitTimeInSeconds;

        try {
            /* new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime))
                    .until(driver -> ((JavascriptExecutor) driver)
                            .executeScript("return document.readyState")
                            .equals("complete"));*/

            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime))
                    .until(driver -> Objects.equals(((JavascriptExecutor) driver)
                            .executeScript("return document.readyState"), "complete"));
        } catch (Exception e) {
//            logger.error("Page load wait failed after {} seconds", waitTime, e);
//            takeScreenshot(); // your method
            ((JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("window.stop();");
            throw e;
        }
    }

    public void ensurePageIsFullyLoaded(int maxWaitTimeInSec) {
        int waitTime = (maxWaitTimeInSec == 0)
                ? Integer.parseInt(PropertyUtils.getValue(ConfigProperties.SELENIUMCOMMANDTIMEOUT))
                : maxWaitTimeInSec;

        try {
            waitForPageLoad(waitTime);   // Ensure full page load
            waitForAjaxCalls(waitTime);  // Ensure all AJAX calls are complete
        } catch (Exception e) {
//            logger.error("⚠️ ensurePageIsFullyLoaded failed.", e);
//            screenshotService.AddExceptionToTestResult("Page load failure: " + e.getMessage());
            throw e;  // Throwing exception to halt test in case of failure
        }
    }


}
