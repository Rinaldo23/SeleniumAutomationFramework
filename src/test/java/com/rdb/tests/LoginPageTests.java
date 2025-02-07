package com.rdb.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rdb.driver.DriverManager;
import com.rdb.listeners.RetryFailedTests;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.time.Duration;

public final class LoginPageTests extends BaseTest {

    private LoginPageTests() {
    }

    @Test(retryAnalyzer = RetryFailedTests.class)
    public void testOne() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10000));
        Assertions.assertThat(DriverManager.getDriver().getTitle())
                .isEqualTo("SSelenium - Google Search");
    }

    @Test
    public void testTwo() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Playwright", Keys.ENTER);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10000));
        Assertions.assertThat(DriverManager.getDriver().getTitle())
                .isEqualTo("Playwright - Google Search");
    }
}
