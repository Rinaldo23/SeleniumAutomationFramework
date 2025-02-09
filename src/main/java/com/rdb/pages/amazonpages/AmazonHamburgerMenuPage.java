package com.rdb.pages.amazonpages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.enums.WaitStrategy;
import com.rdb.pages.BasePage;
import org.openqa.selenium.By;

import java.time.Duration;

public final class AmazonHamburgerMenuPage extends BasePage {

    private final String menuOption = "//div[text()='%replace%']/parent::a";

    private final String subMenuOption = "//a[text()='%replace%']";

    public AmazonHamburgerMenuPage selectHamburgerMenuOption(String optionName) {
        String hamburgerMenuOption = menuOption.replace("%replace%", optionName);
        click(By.xpath(hamburgerMenuOption), optionName, WaitStrategy.CLICKABLE);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return this;
    }

    public AmazonTabletsPage selectHamburgerMenuSubOption(String subOptionName) {
        String hamburgerSubMenuOption = subMenuOption.replace("%replace%", subOptionName);
        mouseHoverAndClick(By.xpath(hamburgerSubMenuOption), subOptionName, WaitStrategy.CLICKABLE);
        return new AmazonTabletsPage();
    }
}
