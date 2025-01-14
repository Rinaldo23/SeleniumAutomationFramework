package com.rdb.tests;

import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class HomePageTests extends BaseTest {

    private HomePageTests() {
    }

    @Test
    public void testThree() throws InterruptedException {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        Thread.sleep(10000);
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Selenium - Google Search");
    }

    @Test
    public void testFour() throws InterruptedException {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Playwright", Keys.ENTER);
        Thread.sleep(10000);
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Playwright - Google Search");
    }


}
