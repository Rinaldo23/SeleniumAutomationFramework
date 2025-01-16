package com.rdb.tests;

import com.rdb.pages.OrangeHRMHomePage;
import com.rdb.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test
    public void loginTest() {

        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        ohlp.enterUsername("Admin");
        ohlp.enterPassword("admin123");
        ohlp.clickLogin();

        OrangeHRMHomePage ohhp = new OrangeHRMHomePage();
        String homePageTitle = ohhp.getTitle();
        Assertions.assertThat(homePageTitle)
                .isNotNull()
                .isNotBlank()
                .isNotEmpty()
                .isEqualTo("OrangeHRM");

        ohhp.clickDropdownMenu();
        ohhp.clickFromMenuoptions("Logout");

        boolean isHeaderTextPresent = ohlp.getHeader();
        Assertions.assertThat(isHeaderTextPresent)
                .isTrue();


    }

}
