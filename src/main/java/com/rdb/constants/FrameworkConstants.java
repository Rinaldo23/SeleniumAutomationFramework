package com.rdb.constants;

import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;

public final class FrameworkConstants {

    private static final String RESOUCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOUCESPATH + "/Executables/chromedriver.exe";
    private static final String EDGEDRIVERPATH = RESOUCESPATH + "/Executables/msedgedriver.exe";
    private static final String GECKODRIVERPATH = RESOUCESPATH + "/Executables/geckodriver.exe";
    private static final String CONFIGFILEPATH = RESOUCESPATH + "/Config/config.properties";
    private static final String JSONCONFIGFILEPATH = RESOUCESPATH + "/Config/config.json";
    private static final String EXCELFILEPATH = RESOUCESPATH + "/Excel/testdata1.xlsx";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static final String TESTDATASHEETNAME = "Tests";
    private static final String DATAPROVIDERSHEETNAME = "DataProviderTests";
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

    public static String getEdgeDriverPath() {
        return EDGEDRIVERPATH;
    }

    public static String getGeckoDriverPath() {
        return GECKODRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getJsonConfigFilePath() {
        return JSONCONFIGFILEPATH;
    }

    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }

    public static String getTestDataSheetname() {
        return TESTDATASHEETNAME;
    }

    public static String getDataProviderSheetname() {
        return DATAPROVIDERSHEETNAME;
    }

    private static String createExtentReportFolderPath() throws Exception {
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "index.html";
        }
    }
}
