package com.rdb.pages;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected BasePage() {
    }

    protected void click(WebElement element, WaitStrategy waitStrategy) {
        if (waitStrategy == WaitStrategy.VISIBLE) {
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
        } else if (waitStrategy == WaitStrategy.CLICKABLE) {
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
        }
        element.click();
    }

    protected void click(By locator, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        click(element, waitStrategy);
    }

    protected void setTextBoxValue(WebElement element, String text, WaitStrategy waitStrategy) {
        if (waitStrategy == WaitStrategy.VISIBLE) {
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
        } else if (waitStrategy == WaitStrategy.CLICKABLE) {
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
        }
        element.sendKeys(text);
    }

    protected void setTextBoxValue(By locator, String text, WaitStrategy waitStrategy) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        setTextBoxValue(element, text, waitStrategy);
    }
}
