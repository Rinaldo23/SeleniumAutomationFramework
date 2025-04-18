package com.rdb.pages;

import com.rdb.enums.WaitStrategy;
import com.rdb.pages.interactions.InteractionService;
import com.rdb.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class HamburgerMenuPage extends BasePage {

    private final String menuOption = "//div[text()=\"%s\"]/parent::a";

    private final String subMenuOption = "//a[text()=\"%s\"]";

    public HamburgerMenuPage(InteractionService interactions) {
        super(interactions);
    }

    public HamburgerMenuPage selectHamburgerMenuOption(String optionName) {
        String hamburgerMenuOption = DynamicXpathUtils.getXpath(menuOption, optionName);
        interactions.click(By.xpath(hamburgerMenuOption), optionName, WaitStrategy.CLICKABLE);
        /* Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5)); */
        interactions.ensurePageIsFullyLoaded(10);
        return this;
    }

    public HamburgerMenuPage selectHamburgerMenuSubOption(String subOptionName) {
        String hamburgerSubMenuOption = DynamicXpathUtils.getXpath(subMenuOption, subOptionName);
        interactions.mouseHoverAndClick(By.xpath(hamburgerSubMenuOption), subOptionName, WaitStrategy.CLICKABLE);
        interactions.ensurePageIsFullyLoaded(10);
        return this;
    }
}
