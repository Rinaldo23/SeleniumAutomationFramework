package com.rdb.driver;

import com.rdb.driver.browser.ChromeBrowserDriver;
import com.rdb.driver.browser.EdgeBrowserDriver;
import com.rdb.driver.browser.FirefoxBrowserDriver;
import com.rdb.driver.browser.IBrowserDriver;
import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriverOptimized(String browserName) {
        IBrowserDriver driver;

        String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);

        switch (browserName.toLowerCase()) {
            case "chrome" -> driver = new ChromeBrowserDriver();
            case "firefox" -> driver = new FirefoxBrowserDriver();
            case "microsoftedge" -> driver = new EdgeBrowserDriver();
            default -> throw new IllegalArgumentException("Invalid Browser Type : " + browserName);
        }

        driver.setEnableHeadlessExecution(Boolean.parseBoolean(PropertyUtils.getValue(ConfigProperties.ENABLEHEADLESSEXECUTION)));

        driver.setRemoteExecution(runmode.equalsIgnoreCase("remote"));

        if (driver.isRemoteExecution()) {
            try {
                return driver.getDriver(new URI("http://localhost:4444/wd/hub").toURL());
            } catch (MalformedURLException | URISyntaxException e) {
                throw new RuntimeException("Invalid remote URL", e);
            }
        } else {
            return driver.getDriver();
        }
    }

    /* public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        chromeOptions.setExperimentalOption("excludeSwitches", List.of("enable-automation")); // Hides Selenium usage
        chromeOptions.setExperimentalOption("useAutomationExtension", false);

        chromeOptions.addArguments("--headless");

        if (browserName.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic - Chrome!!");
                chromeOptions.setCapability("browserName", browserName);
                try {
                    // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    driver = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), chromeOptions);
                } catch (MalformedURLException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Suppress geckodriver and Firefox internal logs
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            // Set Firefox logging level to "OFF" to suppress logs
            firefoxOptions.addPreference("webdriver.log.file", "/dev/null"); // For Linux/macOS
            // For Windows
            firefoxOptions.addPreference("webdriver.log.file", "NUL");

            // Set log level to severe (optional, based on your needs)
            firefoxOptions.setLogLevel(FirefoxDriverLogLevel.fromLevel(Level.SEVERE));

            if (runmode.equalsIgnoreCase("remote")) {
                System.out.println("Remote WebDriver Logic - Firefox!!");
                try {
                    driver = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), firefoxOptions);
                } catch (MalformedURLException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            } else {
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
            }
        } else if (browserName.equalsIgnoreCase("MicrosoftEdge")) {
            if (runmode.equalsIgnoreCase("remote")) {
                // Remote WebDriver Logic to be Implemented
                System.out.println("Remote WebDriver Logic - MicrosoftEdge!!");

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("browserName", browserName);
                try {
                    driver = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), edgeOptions);
                } catch (MalformedURLException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }

            } else {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
            }
        }
        return driver;
    } */
}
