package com.rdb.driver;

import com.rdb.enums.ConfigProperties;
import com.rdb.exceptions.BrowserNotSpecifiedException;
import com.rdb.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browserName) {
        if (Objects.isNull(DriverManager.getDriver())) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            options.setExperimentalOption("excludeSwitches", List.of("enable-automation")); // Hides Selenium usage
            options.setExperimentalOption("useAutomationExtension", false);

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver(options));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                DriverManager.setDriver(new EdgeDriver());
            } else {
                throw new BrowserNotSpecifiedException("Browser not specified in excel data sheet file.");
            }


//            DriverManager.getDriver().get(JsonUtils.getValue(ConfigProperties.URL));
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));

            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().navigate().refresh();
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
