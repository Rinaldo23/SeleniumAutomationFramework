package com.rdb.driver;

import com.rdb.constants.FrameworkConstants;
import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            DriverManager.setDriver(new ChromeDriver());

//            DriverManager.getDriver().get(JsonUtils.getValue(ConfigProperties.URL));
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));

            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
//            driver = null;
            DriverManager.unload();
        }
    }

}
