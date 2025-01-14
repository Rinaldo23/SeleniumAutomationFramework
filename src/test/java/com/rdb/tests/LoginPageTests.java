package com.rdb.tests;

import com.rdb.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTests extends BaseTest {

    private LoginPageTests() {
    }

    @Test
    public void testOne() {
        Driver.driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

    @Test
    public void testTwo() {
        Driver.driver.findElement(By.name("q")).sendKeys("Playwright", Keys.ENTER);
    }
}
