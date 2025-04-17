package com.rdb.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.enums.WaitStrategy;
import com.rdb.interactions.Interactions;
import org.openqa.selenium.By;

import java.time.Duration;

public final class HeaderPage extends BasePage {

    private final By searchTxtBox = By.xpath("//div[@class='nav-search-field ']/child::input");

    private final By searchBtn = By.xpath("//div[contains(@class, 'nav-search-submit')]/child::span");

    public HeaderPage(Interactions interactions) {
        super(interactions);
    }

    public HeaderPage searchForProduct(String productName) {
        interactions.setTextBoxValue(searchTxtBox, productName, WaitStrategy.CLICKABLE);
        interactions.click(searchBtn, "searchBtn", WaitStrategy.CLICKABLE);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return this;
    }
}
