package com.rdb.pages.interactions.implementations;

import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.declarations.IDropdownInteraction;
import com.rdb.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownInteraction implements IDropdownInteraction {

    @Override
    public void selectByVisibleText(By lookupBy, String elementName, String visibleText, int waitTime) {
        WebElement dropdownElement = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    @Override
    public void selectByValue(By lookupBy, String elementName, String value, int waitTime) {
        WebElement dropdownElement = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    @Override
    public void selectByIndex(By lookupBy, String elementName, int index, int waitTime) {
        WebElement dropdownElement = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

}
