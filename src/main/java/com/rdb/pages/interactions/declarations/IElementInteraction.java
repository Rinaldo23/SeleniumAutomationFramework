package com.rdb.pages.interactions.declarations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IElementInteraction {

    boolean isElementInteractable(By lookupBy, String elementName, int waitTime);

    WebElement getElement(By lookupBy, String elementName, int waitTime);

    List<WebElement> getListOfELements(By lookupBy, String elementsName, int waitTime);

    String getElementAttribute(By lookupBy, String elementName, String attribute, int waitTime);

    boolean checkIfElementsExistsInDOM(By lookupBy, String elementName, int waitTime);

    void click(By lookupBy, String elementName, int waitTime);

    void clickUsingJS(By lookupBy, String elementName, int waitTime);
}
