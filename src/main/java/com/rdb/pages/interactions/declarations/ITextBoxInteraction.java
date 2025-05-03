package com.rdb.pages.interactions.declarations;

import org.openqa.selenium.By;

public interface ITextBoxInteraction {

    void setTextBoxValue(By lookupBy, String elementName, String value, int waitTime);
    
}
