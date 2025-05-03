package com.rdb.pages.interactions.implementations;

import com.rdb.driver.DriverManager;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.declarations.IKeyboardInteraction;
import com.rdb.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardInteraction implements IKeyboardInteraction {

    @Override
    public void pressKey(Keys key) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.keyDown(key).perform();
    }

    @Override
    public void releaseKey(Keys key) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.keyUp(key).perform();
    }

    @Override
    public void sendKeys(By lookupBy, String elementName, String keys, int waitTime) {
        WebElement element = WaitUtils.waitForElement(lookupBy, WaitStrategy.VISIBLE, waitTime);
        element.sendKeys(keys);
    }
}
