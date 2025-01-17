package com.rdb.tests;

import com.rdb.pages.OrangeHRMHomePage;
import com.rdb.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test
    public void loginTest() {

        String homePageTitle = new OrangeHRMLoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .getHomePageTitle();

        assertThat(homePageTitle)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty()
                .isEqualTo("OrangeHRM");

        boolean isHeaderTextPresent = new OrangeHRMHomePage()
                .clickDropdownMenu()
                .clickFromMenuOptions("Logout")
                .getLoginPageHeader();
        assertThat(isHeaderTextPresent)
                .isTrue();

    }

}
