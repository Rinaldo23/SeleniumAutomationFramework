package com.rdb.pages.interactions.declarations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public interface IKeyboardInteraction {

    void pressKey(Keys key);

    void releaseKey(Keys key);

    void sendKeys(By lookupBy, String elementName, String keys, int waitTime);

}
