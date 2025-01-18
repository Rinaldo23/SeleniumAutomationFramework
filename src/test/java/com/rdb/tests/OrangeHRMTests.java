package com.rdb.tests;

import com.rdb.pages.OrangeHRMHomePage;
import com.rdb.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test()
    public void loginTest() {

        String homePageUrl = new OrangeHRMLoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
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
}
