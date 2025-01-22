package com.rdb.tests;

import com.rdb.pages.OrangeHRMHomePage;
import com.rdb.pages.OrangeHRMLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test(dataProvider = "loginCredentials")
    public void loginTestWithValidCredentials(String username, String password) {

        String homePageUrl = new OrangeHRMLoginPage()
                .enterUsername(username)
                .enterPassword(password)
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

    @Test(dataProvider = "loginCredentials")
    public void loginTestWithInValidCredentials(String username, String password) {

        String homePageUrl = new OrangeHRMLoginPage()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .getPageUrl();

        assertThat(homePageUrl)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty()
                .containsPattern("/auth/login");
    }

    @DataProvider(name = "loginCredentials", parallel = true)
    public String[][] getData(Method m) {
        String[][] data;
        if (m.getName().equalsIgnoreCase("loginTestWithValidCredentials")) {
            data = new String[][]{
                    {"Admin", "admin123"},
                    {"Admin", "admin123"},
                    {"Admin", "admin123"}
            };
        } else {
            data = new String[][]{
                    {"Admin", "admin1234"},
                    {"Admewin", "admin123"},
                    {"Admin", " "}
            };
        }
        return data;
    }


}
