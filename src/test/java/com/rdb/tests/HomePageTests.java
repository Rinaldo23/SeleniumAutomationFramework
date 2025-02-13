package com.rdb.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public final class HomePageTests extends BaseTest {

    private HomePageTests() {
    }

    @Test
    public void testThree() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Selenium - Google Search");
    }

    @Test(enabled = false)
    public void testFour() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Playwright", Keys.ENTER);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Playwright - Google Search");
    }


}
