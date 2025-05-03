package com.rdb.pages.interactions.declarations;

import org.openqa.selenium.By;

public interface ICheckboxInteraction {

    void selectCheckbox(By lookupBy, String elementName, int waitTime);

    void selectCheckboxUsingJS(By lookupBy, String elementName, int waitTime);

    void uncheckCheckBox(By lookupBy, String elementName, int waitTime);

    void uncheckCheckBoxUsingJS(By lookupBy, String elementName, int waitTime);
    
}
