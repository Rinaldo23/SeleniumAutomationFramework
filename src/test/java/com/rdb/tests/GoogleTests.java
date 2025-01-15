package com.rdb.tests;

import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public class GoogleTests extends BaseTest {

    private GoogleTests() {
    }

    @Test
    public void myFirstGoogleTest() throws InterruptedException {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        Thread.sleep(3000);

        String pageTitle = DriverManager.getDriver().getTitle();

        Assert.assertTrue(Objects.nonNull(pageTitle), "Page title is null");
        Assert.assertTrue(pageTitle.toLowerCase().contains("google search"), "Page title doesn't contain google search!");
        Assert.assertTrue(pageTitle.length() > 5);
        Assert.assertTrue(pageTitle.length() < 100);

        List<WebElement> listOfElements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        boolean isElementPresent = false;
        for (WebElement element : listOfElements) {
            if (element.getText().equalsIgnoreCase("Selenium")) {
                isElementPresent = true;
                break;
            }
        }

        Assert.assertTrue(isElementPresent, "Element is not present!!!");

    }

}
