package com.rdb.tests;

import com.rdb.listeners.RetryFailedTests;
import com.rdb.pages.OrangeHRMHomePage;
import com.rdb.pages.OrangeHRMLoginPage;
import com.rdb.utils.DataProviderUtils;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class)
    public void loginTestWithValidCredentials(Map<String, String> m) {

        String homePageUrl = new OrangeHRMLoginPage()
                .enterUsername(m.get("username"))
                .enterPassword(m.get("password"))
                .clickLogin()
                .getPageUrl();

        assertThat(homePageUrl)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty()
                .containsPattern("/dashboard/");

        String loginPageUrl = new OrangeHRMHomePage()
                .clickDropdownMenu()
                .clickFromMenuOptions("Logout")
                .getPageUrl();

        assertThat(loginPageUrl)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty()
                .containsPattern("/auth/login");
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void loginTestWithInValidCredentials(Map<String, String> m) {

        String homePageUrl = new OrangeHRMLoginPage()
                .enterUsername(m.get("username"))
                .enterPassword(m.get("password"))
                .clickLogin()
                .getPageUrl();

        assertThat(homePageUrl)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty()
                .containsPattern("/auth/login");
    }

//    @DataProvider(name = "loginCredentials")
//    public String[][] getData(Method m) {
//        String[][] data;
//        if (m.getName().equalsIgnoreCase("loginTestWithValidCredentials")) {
//            data = new String[][]{
//                    {"Admin", "admin123"},
////                    {"Admin", "admin123"},
////                    {"Admin", "admin123"}
//            };
//        } else {
//            data = new String[][]{
//                    {"Admin", "admin1234"},
////                    {"Admewin", "admin123"},
////                    {"Admin", " "}
//            };
//        }
//        return data;
//    }


}
