package com.rdb.tests;

import com.rdb.FrameworkAnnotation;
import com.rdb.pages.amazonpages.AmazonHomePage;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class AmazonTests extends BaseTest {

    private AmazonTests() {
    }

    @FrameworkAnnotation(authors = {"Rinaldo", "Pankaj"}, categories = {"Smoke", "Regression"})
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
