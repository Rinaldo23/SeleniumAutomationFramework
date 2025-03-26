package com.rdb.factories;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(WebElement element, WaitStrategy waitStrategy) {
        WebElement webElement = null;
        if (waitStrategy == WaitStrategy.VISIBLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOf(element));
        } else if (waitStrategy == WaitStrategy.CLICKABLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.elementToBeClickable(element));
        }
        return webElement;
    }
}
