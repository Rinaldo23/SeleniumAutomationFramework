package com.rdb.tests;

import com.rdb.pages.amazonpages.AmazonHomePage;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AmazonTests extends BaseTest {

    private AmazonTests() {
    }

    @Test
    public void navigateToTabletsPageViaHamburgerMenuTest(Map<String, String> m) {
        String pageTitle = new AmazonHomePage()
                .openAllCategoriesHamburgerMenu()
                .selectHamburgerMenuOption("Mobiles, Computers")
                .selectHamburgerMenuSubOption("Tablets")
                .getPageTitle();

        assertThat(pageTitle)
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .containsIgnoringCase("Tablets");
    }

}
