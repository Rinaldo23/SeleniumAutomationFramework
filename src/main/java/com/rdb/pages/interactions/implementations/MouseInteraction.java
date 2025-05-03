package com.rdb.pages.interactions.implementations;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.declarations.IMouseInteraction;
import com.rdb.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseInteraction implements IMouseInteraction {

    @Override
    public void mouseHoverAndClick(By lookupBy, String elementName, int waitTime) {
        WebElement element = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element)
                .click()
                .perform();
    }

    @Override
    public void mouseHover(By lookupBy, String elementName, int waitTime) {
        WebElement element = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        new Actions(DriverManager.getDriver())
                .scrollToElement(element)
                .moveToElement(element)
                .perform();
    }
    
}
