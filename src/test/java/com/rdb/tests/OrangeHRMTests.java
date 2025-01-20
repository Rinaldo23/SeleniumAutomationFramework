package com.rdb.tests;

import com.rdb.pages.OrangeHRMHomePage;
import com.rdb.pages.OrangeHRMLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test(dataProvider = "loginCredentials")
    public void loginTest(String username, String password) {

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


    @DataProvider(name = "loginCredentials")
    public String[][] getData() {
        return new String[][]{
                {"Admin", "admin123"},
                {"Admin", "admin123"},
                {"Admin", "admin123"}
        };
    }

}
