package com.rdb.pages.interactions.declarations;

import org.openqa.selenium.By;

public interface IPageInteraction {

    void waitForPageLoad(int maxWaitTimeInSeconds);

    void waitForAjaxCalls(int maxWaitTimeInSeconds);

    void ensurePageIsFullyLoaded(int maxWaitTimeInSec);

    void scrollToElement(By locator, String elementName, int waitTime);

    void scrollToTop();

    void scrollToBottom();
}
