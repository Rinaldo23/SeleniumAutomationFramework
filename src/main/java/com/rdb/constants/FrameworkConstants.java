package com.rdb.constants;

public final class FrameworkConstants {

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/Executables/chromedriver.exe";

    private FrameworkConstants() {
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }
}
