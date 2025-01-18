package com.rdb.constants;

public final class FrameworkConstants {

    private static final String RESOUCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOUCESPATH + "/Executables/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOUCESPATH + "/Config/config.properties";
    private static final String JSONCONFIGFILEPATH = RESOUCESPATH + "/Config/config.json";


    private FrameworkConstants() {
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getJsonConfigFilePath() {
        return JSONCONFIGFILEPATH;
    }
}
