package com.rdb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void testThree() {
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

}
