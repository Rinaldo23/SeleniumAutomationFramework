package com.rdb.tests;

import com.rdb.annotations.FrameworkAnnotation;
import com.rdb.enums.CategoryType;
import com.rdb.interactions.Interactions;
import com.rdb.pages.AmazonHomePage;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class AmazonHamburgerMenuTests extends BaseTest {

    private AmazonHamburgerMenuTests() {
    }

    @FrameworkAnnotation(authors = {"Rinaldo"}, categories = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void navigateToTabletsPageViaHamburgerMenuTest(Map<String, String> data) {
        String pageTitle = new AmazonHomePage(new Interactions())
                .openAllCategoriesHamburgerMenu()
                .selectHamburgerMenuOption(data.get("menuoption"))
                .selectHamburgerMenuSubOption(data.get("submenuoption"))
                .getPageTitle();

        assertThat(pageTitle)
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .containsIgnoringCase(data.get("submenuoption"));
    }

    @FrameworkAnnotation(authors = {"Pankaj"}, categories = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test
    public void navigateToMensFashionPageViaHamburgerMenuTest(Map<String, String> data) {
        String pageTitle = new AmazonHomePage(new Interactions())
                .openAllCategoriesHamburgerMenu()
                .selectHamburgerMenuOption(data.get("menuoption"))
                .selectHamburgerMenuSubOption(data.get("submenuoption"))
                .getPageTitle();

        assertThat(pageTitle)
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .containsIgnoringCase(data.get("submenuoption"));
    }

    @FrameworkAnnotation(authors = {"Hrishi"}, categories = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test
    public void navigateToAmazonPrimeVideoPageViaHamburgerMenuTest(Map<String, String> data) {
        String pageTitle = new AmazonHomePage(new Interactions())
                .openAllCategoriesHamburgerMenu()
                .selectHamburgerMenuOption(data.get("menuoption"))
                .selectHamburgerMenuSubOption(data.get("submenuoption"))
                .getPageTitle();

        assertThat(pageTitle)
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .containsIgnoringCase(data.get("submenuoption"));
    }

}
