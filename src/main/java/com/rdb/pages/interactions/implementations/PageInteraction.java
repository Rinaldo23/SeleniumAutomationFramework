package com.rdb.pages.interactions.implementations;

import com.rdb.driver.DriverManager;
import com.rdb.enums.ConfigProperties;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.declarations.IPageInteraction;
import com.rdb.utils.PropertyUtils;
import com.rdb.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class PageInteraction implements IPageInteraction {

    @Override
    public void waitForPageLoad(int maxWaitTimeInSeconds) {
        int waitTime = (maxWaitTimeInSeconds == 0)
                ? Integer.parseInt(PropertyUtils.getValue(ConfigProperties.PAGELOADWAITTIME))
                : maxWaitTimeInSeconds;

        try {
            /* new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime))
                    .until(driver -> ((JavascriptExecutor) driver)
                            .executeScript("return document.readyState")
                            .equals("complete"));*/

            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime)).until(driver -> Objects.equals(((JavascriptExecutor) driver).executeScript("return document.readyState"), "complete"));
        } catch (Exception e) {
//            logger.error("Page load wait failed after {} seconds", waitTime, e);
//            takeScreenshot(); // your method
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.stop();");
            throw e;
        }
    }

    @Override
    public void waitForAjaxCalls(int maxWaitTimeInSeconds) {
        int waitTime = (maxWaitTimeInSeconds == 0)
                ? Integer.parseInt(PropertyUtils.getValue(ConfigProperties.SELENIUMCOMMANDTIMEOUT))
                : maxWaitTimeInSeconds;

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

    @Override
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


    @Override
    public void scrollToElement(By locator, String elementName, int waitTime) {
        WebElement element = WaitUtils.waitForElement(locator, WaitStrategy.VISIBLE, waitTime);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public void scrollToTop() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0, 0);");
    }

    @Override
    public void scrollToBottom() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
