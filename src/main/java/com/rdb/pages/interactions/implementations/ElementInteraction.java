package com.rdb.pages.interactions.implementations;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.declarations.IElementInteraction;
import com.rdb.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementInteraction implements IElementInteraction {

    @Override
    public boolean isElementInteractable(By lookupBy, String elementName, int waitTime) {
        try {
            WebElement element = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
            return element.isDisplayed() && element.isEnabled();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public WebElement getElement(By lookupBy, String elementName, int waitTime) {
        return WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
    }

    @Override
    public List<WebElement> getListOfELements(By lookupBy, String elementsName, int waitTime) {
        return WaitUtils.waitForElements(lookupBy, WaitStrategy.VISIBILITYOFALL, waitTime);
    }

    @Override
    public String getElementAttribute(By lookupBy, String elementName, String attribute, int waitTime) {
        WebElement element = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        return element.getDomAttribute(attribute);
    }

    @Override
    public boolean checkIfElementsExistsInDOM(By lookupBy, String elementName, int waitTime) {
        try {
            WaitUtils.waitForElement(lookupBy, WaitStrategy.PRESENCE, waitTime);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public void click(By lookupBy, String elementName, int waitTime) {
        WebElement element = WaitUtils.waitForElement(lookupBy, WaitStrategy.CLICKABLE, waitTime);
        element.click();
    }

    @Override
    public void clickUsingJS(By lookupBy, String elementName, int waitTime) {
        WebElement element = WaitUtils.waitForElement(lookupBy, WaitStrategy.CLICKABLE, waitTime);
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].click()", element);
    }


}
