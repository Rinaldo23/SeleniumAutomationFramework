package com.rdb.tests;

import com.rdb.driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTests extends BaseTest {

    private GoogleTests() {
    }

    @Test
    public void myFirstGoogleTest() throws InterruptedException {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        Thread.sleep(3000);

        String pageTitle = DriverManager.getDriver().getTitle();

        Assertions.assertThat(pageTitle)
                .as("Page title is null!").isNotNull()
                .as("Page title doesn't contain google search!").containsIgnoringCase("google search")
                .as("Size is not between the given range!").hasSizeBetween(5, 50);

        /*Assert.assertTrue(Objects.nonNull(pageTitle), "Page title is null");
        Assert.assertTrue(pageTitle.toLowerCase().contains("google search"), "Page title doesn't contain google search!");
        Assert.assertTrue(pageTitle.length() > 5);
        Assert.assertTrue(pageTitle.length() < 100);*/

        List<WebElement> listOfElements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        Assertions.assertThat(listOfElements)
                .hasSize(16)
                .extracting(WebElement::getText)
                .contains("Selenium");

        /*boolean isElementPresent = false;
        for (WebElement element : listOfElements) {
            if (element.getText().equalsIgnoreCase("Selenium")) {
                isElementPresent = true;
                break;
            }
        }
        Assert.assertTrue(isElementPresent, "Element is not present!!!");*/

    }

}
