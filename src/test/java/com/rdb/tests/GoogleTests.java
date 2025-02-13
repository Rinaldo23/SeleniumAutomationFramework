package com.rdb.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleTests extends BaseTest {

    private GoogleTests() {
    }

    @Test
    public void myFirstGoogleTest() {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        String pageTitle = DriverManager.getDriver().getTitle();
        assertThat(pageTitle)
                .as("Page title is null!").isNotNull()
                .as("Page title doesn't contain google search!").containsIgnoringCase("google search")
                .as("Size is not between the given range!").hasSizeBetween(5, 50);

        List<WebElement> listOfElements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        assertThat(listOfElements)
                .hasSize(16)
                .extracting(WebElement::getText)
                .contains("Selenium");

    }
}
