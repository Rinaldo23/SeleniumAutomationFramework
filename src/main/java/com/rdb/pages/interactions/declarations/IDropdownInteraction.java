package com.rdb.pages.interactions.declarations;

import org.openqa.selenium.By;

public interface IDropdownInteraction {

    void selectByVisibleText(By lookupBy, String elementName, String visibleText, int waitTime);

    void selectByValue(By lookupBy, String elementName, String value, int waitTime);

    void selectByIndex(By lookupBy, String elementName, int index, int waitTime);
}
