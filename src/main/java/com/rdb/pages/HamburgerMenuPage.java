package com.rdb.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.enums.WaitStrategy;
import com.rdb.interactions.Interactions;
import com.rdb.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import java.time.Duration;

public final class HamburgerMenuPage extends BasePage {

    private final String menuOption = "//div[text()=\"%s\"]/parent::a";

    private final String subMenuOption = "//a[text()=\"%s\"]";

    public HamburgerMenuPage(Interactions interactions) {
        super(interactions);
    }

    public HamburgerMenuPage selectHamburgerMenuOption(String optionName) {
        String hamburgerMenuOption = DynamicXpathUtils.getXpath(menuOption, optionName);
        interactions.click(By.xpath(hamburgerMenuOption), optionName, WaitStrategy.CLICKABLE);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        return this;
    }

    public TabletsPage selectHamburgerMenuSubOption(String subOptionName) {
        String hamburgerSubMenuOption = DynamicXpathUtils.getXpath(subMenuOption, subOptionName);
        interactions.mouseHoverAndClick(By.xpath(hamburgerSubMenuOption), subOptionName, WaitStrategy.CLICKABLE);
        return new TabletsPage(interactions);
    }
}
