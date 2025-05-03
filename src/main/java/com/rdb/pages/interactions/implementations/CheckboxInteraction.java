package com.rdb.pages.interactions.implementations;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.declarations.ICheckboxInteraction;
import com.rdb.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CheckboxInteraction implements ICheckboxInteraction {

    @Override
    public void selectCheckbox(By lookupBy, String elementName, int waitTime) {
        WebElement checkbox = WaitUtils.waitForElement(lookupBy, WaitStrategy.CLICKABLE, waitTime);
        if (!checkbox.isSelected()) {
            checkbox.click();
            // Log this action to report
        }
    }

    @Override
    public void selectCheckboxUsingJS(By lookupBy, String elementName, int waitTime) {
        WebElement checkbox = WaitUtils.waitForElement(lookupBy, WaitStrategy.CLICKABLE, waitTime);
        if (!checkbox.isSelected()) {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();", checkbox);
            // Log this action to report
        }
    }

    @Override
    public void uncheckCheckBox(By lookupBy, String elementName, int waitTime) {
        WebElement checkbox = WaitUtils.waitForElement(lookupBy, WaitStrategy.CLICKABLE, waitTime);
        if (checkbox.isSelected()) {
            checkbox.click();
            // Log this action to report
        }
    }


    @Override
    public void uncheckCheckBoxUsingJS(By lookupBy, String elementName, int waitTime) {
        WebElement checkbox = WaitUtils.waitForElement(lookupBy, WaitStrategy.CLICKABLE, waitTime);
        if (checkbox.isSelected()) {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();", checkbox);
            // Log this action to report
        }
    }

}
