package com.rdb.pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IInteractionService {

    /* CheckboxInteraction */
    void selectCheckbox(By lookupBy, String elementName, int waitTime);

    void selectCheckboxUsingJS(By lookupBy, String elementName, int waitTime);

    void uncheckCheckBox(By lookupBy, String elementName, int waitTime);

    void uncheckCheckBoxUsingJS(By lookupBy, String elementName, int waitTime);

    /* DropdownInteraction */

    void selectByVisibleText(By lookupBy, String elementName, String visibleText, int waitTime);

    void selectByValue(By lookupBy, String elementName, String value, int waitTime);

    void selectByIndex(By lookupBy, String elementName, int index, int waitTime);

    /* ElementInteraction */

    boolean isElementInteractable(By lookupBy, String elementName, int waitTime);

    WebElement getElement(By lookupBy, String elementName, int waitTime);

    List<WebElement> getListOfELements(By lookupBy, String elementsName, int waitTime);

    String getElementAttribute(By lookupBy, String elementName, String attribute, int waitTime);

    void click(By lookupBy, String elementName, int waitTime);

    void clickUsingJS(By lookupBy, String elementName, int waitTime);

    /* KeyboardInteraction */

    boolean checkIfElementsExistsInDOM(By lookupBy, String elementName, int waitTime);

    void pressKey(Keys key);

    void releaseKey(Keys key);

    void sendKeys(By lookupBy, String elementName, String keys, int waitTime);

    /* MouseInteraction */

    void mouseHoverAndClick(By lookupBy, String elementName, int waitTime);

    void mouseHover(By lookupBy, String elementName, int waitTime);

    /* PageInteraction */

    void waitForPageLoad(int maxWaitTimeInSeconds);

    void waitForAjaxCalls(int maxWaitTimeInSeconds);

    void ensurePageIsFullyLoaded(int maxWaitTimeInSec);

    void scrollToElement(By locator, String elementName, int waitTime);

    void scrollToTop();

    void scrollToBottom();

    /* TextBoxInteraction */

    void setTextBoxValue(By lookupBy, String elementName, String value, int waitTime);

}