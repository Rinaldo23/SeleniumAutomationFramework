package com.rdb.pages.amazonpages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.BasePage;
import com.rdb.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import java.time.Duration;

public final class AmazonHamburgerMenuPage extends BasePage {

    private final String menuOption = "//div[text()='%s']/parent::a";

    private final String subMenuOption = "//a[text()='%s']";

    public AmazonHamburgerMenuPage selectHamburgerMenuOption(String optionName) {
        String hamburgerMenuOption = DynamicXpathUtils.getXpath(menuOption, optionName);
        click(By.xpath(hamburgerMenuOption), optionName, WaitStrategy.CLICKABLE);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        return this;
    }

    public AmazonTabletsPage selectHamburgerMenuSubOption(String subOptionName) {
        String hamburgerSubMenuOption = DynamicXpathUtils.getXpath(subMenuOption, subOptionName);
        mouseHoverAndClick(By.xpath(hamburgerSubMenuOption), subOptionName, WaitStrategy.CLICKABLE);
        return new AmazonTabletsPage();
    }
}
