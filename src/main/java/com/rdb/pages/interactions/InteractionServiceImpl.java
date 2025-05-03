package com.rdb.pages.interactions;

import com.rdb.pages.interactions.declarations.*;
import com.rdb.pages.interactions.implementations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/* Facade Design Pattern */
public class InteractionServiceImpl implements IInteractionService {

    private final ICheckboxInteraction checkboxInteraction;
    private final IDropdownInteraction dropdownInteraction;
    private final IElementInteraction elementInteraction;
    private final ITextBoxInteraction textBoxInteraction;
    private final IMouseInteraction mouseInteraction;
    private final IKeyboardInteraction keyboardInteraction;
    private final IPageInteraction pageInteraction;

    public InteractionServiceImpl() {
        this.checkboxInteraction = new CheckboxInteraction();
        this.dropdownInteraction = new DropdownInteraction();
        this.elementInteraction = new ElementInteraction();
        this.textBoxInteraction = new TextBoxInteraction();
        this.mouseInteraction = new MouseInteraction();
        this.keyboardInteraction = new KeyboardInteraction();
        this.pageInteraction = new PageInteraction();
    }

    @Override
    public void selectCheckbox(By lookupBy, String elementName, int waitTime) {
        checkboxInteraction.selectCheckbox(lookupBy, elementName, waitTime);
    }

    @Override
    public void selectCheckboxUsingJS(By lookupBy, String elementName, int waitTime) {
        checkboxInteraction.selectCheckboxUsingJS(lookupBy, elementName, waitTime);
    }

    @Override
    public void uncheckCheckBox(By lookupBy, String elementName, int waitTime) {
        checkboxInteraction.uncheckCheckBox(lookupBy, elementName, waitTime);
    }

    @Override
    public void uncheckCheckBoxUsingJS(By lookupBy, String elementName, int waitTime) {
        checkboxInteraction.uncheckCheckBoxUsingJS(lookupBy, elementName, waitTime);
    }

    @Override
    public void selectByVisibleText(By lookupBy, String elementName, String visibleText, int waitTime) {
        dropdownInteraction.selectByVisibleText(lookupBy, elementName, visibleText, waitTime);
    }

    @Override
    public void selectByValue(By lookupBy, String elementName, String value, int waitTime) {
        dropdownInteraction.selectByValue(lookupBy, elementName, value, waitTime);
    }

    @Override
    public void selectByIndex(By lookupBy, String elementName, int index, int waitTime) {
        dropdownInteraction.selectByIndex(lookupBy, elementName, index, waitTime);
    }

    @Override
    public boolean isElementInteractable(By lookupBy, String elementName, int waitTime) {
        return elementInteraction.isElementInteractable(lookupBy, elementName, waitTime);
    }

    @Override
    public WebElement getElement(By lookupBy, String elementName, int waitTime) {
        return elementInteraction.getElement(lookupBy, elementName, waitTime);
    }

    @Override
    public List<WebElement> getListOfELements(By lookupBy, String elementsName, int waitTime) {
        return elementInteraction.getListOfELements(lookupBy, elementsName, waitTime);
    }

    @Override
    public String getElementAttribute(By lookupBy, String elementName, String attribute, int waitTime) {
        return elementInteraction.getElementAttribute(lookupBy, elementName, attribute, waitTime);
    }

    @Override
    public void click(By lookupBy, String elementName, int waitTime) {
        elementInteraction.click(lookupBy, elementName, waitTime);
    }

    @Override
    public void clickUsingJS(By lookupBy, String elementName, int waitTime) {
        elementInteraction.clickUsingJS(lookupBy, elementName, waitTime);
    }

    @Override
    public boolean checkIfElementsExistsInDOM(By lookupBy, String elementName, int waitTime) {
        return elementInteraction.checkIfElementsExistsInDOM(lookupBy, elementName, waitTime);
    }

    @Override
    public void pressKey(Keys key) {
        keyboardInteraction.pressKey(key);
    }

    @Override
    public void releaseKey(Keys key) {
        keyboardInteraction.releaseKey(key);
    }

    @Override
    public void sendKeys(By lookupBy, String elementName, String keys, int waitTime) {
        keyboardInteraction.sendKeys(lookupBy, elementName, keys, waitTime);
    }

    @Override
    public void mouseHoverAndClick(By lookupBy, String elementName, int waitTime) {
        mouseInteraction.mouseHoverAndClick(lookupBy, elementName, waitTime);
    }

    @Override
    public void mouseHover(By lookupBy, String elementName, int waitTime) {
        mouseInteraction.mouseHover(lookupBy, elementName, waitTime);
    }

    @Override
    public void waitForPageLoad(int maxWaitTimeInSeconds) {
        pageInteraction.waitForPageLoad(maxWaitTimeInSeconds);
    }

    @Override
    public void waitForAjaxCalls(int maxWaitTimeInSeconds) {
        pageInteraction.waitForAjaxCalls(maxWaitTimeInSeconds);
    }

    @Override
    public void ensurePageIsFullyLoaded(int maxWaitTimeInSec) {
        pageInteraction.ensurePageIsFullyLoaded(maxWaitTimeInSec);
    }

    @Override
    public void scrollToElement(By locator, String elementName, int waitTime) {
        pageInteraction.scrollToElement(locator, elementName, waitTime);
    }

    @Override
    public void scrollToTop() {
        pageInteraction.scrollToTop();
    }

    @Override
    public void scrollToBottom() {
        pageInteraction.scrollToBottom();
    }

    @Override
    public void setTextBoxValue(By lookupBy, String elementName, String value, int waitTime) {
        textBoxInteraction.setTextBoxValue(lookupBy, elementName, value, waitTime);
    }
}
