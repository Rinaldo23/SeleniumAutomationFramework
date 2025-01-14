package com.rdb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {


    @Test
    public void testOne() {
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

    @Test
    public void testTwo() {
        driver.findElement(By.name("q")).sendKeys("Playwright", Keys.ENTER);
    }
}
