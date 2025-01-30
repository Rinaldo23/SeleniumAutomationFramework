package com.rdb.constants;

import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;

public final class FrameworkConstants {

    private static final String RESOUCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOUCESPATH + "/Executables/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOUCESPATH + "/Config/config.properties";
    private static final String JSONCONFIGFILEPATH = RESOUCESPATH + "/Config/config.json";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static String extentReportFilePath = "";

    private FrameworkConstants() {
    }

    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createExtentReportFolderPath();
        }
        return extentReportFilePath;
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

    private static String createExtentReportFolderPath() throws Exception {
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "index.html";
        }
    }
}
