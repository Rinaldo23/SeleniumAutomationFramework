package com.rdb.tests;

import com.rdb.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTests extends BaseTest {

    private HomePageTests() {
    }

    @Test
    public void testThree() {
//        Driver.initDriver();
        Driver.driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

}
