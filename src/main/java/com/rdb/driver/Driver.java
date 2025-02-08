package com.rdb.driver;

import com.rdb.constants.FrameworkConstants;
import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browserName) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {

            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                DriverManager.setDriver(new ChromeDriver());
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
                DriverManager.setDriver(new FirefoxDriver());
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", FrameworkConstants.getEdgeDriverPath());
                DriverManager.setDriver(new EdgeDriver());
            } else {
                throw new RuntimeException("Browser not specified..!!!");
            }


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
