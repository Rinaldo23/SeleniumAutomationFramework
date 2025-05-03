package com.rdb.utils;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class WaitUtils {

    private WaitUtils() {
    }

    public static WebElement waitForElement(By locator, WaitStrategy waitStrategy, int waitTime) {
        WebElement webElement = null;
        if (waitStrategy == WaitStrategy.VISIBLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else if (waitStrategy == WaitStrategy.CLICKABLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        return webElement;
    }

    public static List<WebElement> waitForElements(By locator, WaitStrategy waitStrategy, int waitTime) {
        List<WebElement> webElements = null;
        if (waitStrategy == WaitStrategy.VISIBILITYOFALL) {
            webElements = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTime))
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        }
        return webElements;
    }
}
