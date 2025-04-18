package com.rdb.pages;

import com.rdb.enums.WaitStrategy;
import com.rdb.interactions.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class HeaderPage extends BasePage {

    private final By searchTxtBox = By.xpath("//div[@class='nav-search-field ']/child::input");

    private final By searchBtn = By.xpath("//div[contains(@class, 'nav-search-submit')]/child::span");

    private final By languageDrpdwn = By.id("icp-nav-flyout");

    private final By listOfLangBtn = By.xpath("//div[@id='nav-flyout-icp']/child::div[contains(@class, 'itemList')]/a[contains(@lang,'-')]");


    public HeaderPage(Interactions interactions) {
        super(interactions);
    }

    public HeaderPage searchForProduct(String productName) {
        interactions.setTextBoxValue(searchTxtBox, productName, WaitStrategy.CLICKABLE);
        interactions.click(searchBtn, "searchBtn", WaitStrategy.CLICKABLE);
        /* Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5)); */
        interactions.ensurePageIsFullyLoaded(20);
        return this;
    }

    public HeaderPage selectLanguageAtRandom() {
        interactions.mouseHover(languageDrpdwn, "languageDrpdwn", WaitStrategy.VISIBLE);
        List<WebElement> langOptions = interactions.getListOfELements(listOfLangBtn, WaitStrategy.VISIBLE);
        int randomNumber = ThreadLocalRandom.current().nextInt(1, langOptions.size());

        for (int i = 1; i <= langOptions.size(); i++) {
            if (i == randomNumber) {
                WebElement dropDownEle = langOptions.get(i);
                interactions.click(dropDownEle, "dropDownEle", WaitStrategy.CLICKABLE);
                break;
            }
        }
        /* Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5)); */
        interactions.ensurePageIsFullyLoaded(20);
        return this;
    }
}
