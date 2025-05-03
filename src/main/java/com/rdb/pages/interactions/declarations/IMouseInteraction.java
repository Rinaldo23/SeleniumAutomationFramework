package com.rdb.pages.interactions.declarations;

import org.openqa.selenium.By;

public interface IMouseInteraction {

    void mouseHoverAndClick(By lookupBy, String elementName, int waitTime);

    void mouseHover(By lookupBy, String elementName, int waitTime);
}
