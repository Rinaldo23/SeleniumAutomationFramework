package com.rdb.pages.interactions.implementations;

import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.declarations.ITextBoxInteraction;
import com.rdb.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBoxInteraction implements ITextBoxInteraction {

    @Override
    public void setTextBoxValue(By lookupBy, String elementName, String value, int waitTime) {
        WebElement textBox = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        textBox.clear();
        textBox.sendKeys(value);
    }
}
