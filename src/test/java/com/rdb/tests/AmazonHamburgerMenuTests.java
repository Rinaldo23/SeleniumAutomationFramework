package com.rdb.tests;

import com.rdb.annotations.FrameworkAnnotation;
import com.rdb.dependencies.HamburgerMenuDependencies;
import com.rdb.dependencies.IHamburgerMenuDependencies;
import com.rdb.enums.CategoryType;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class AmazonHamburgerMenuTests extends BaseTest {

    private final IHamburgerMenuDependencies dependencies;

    private AmazonHamburgerMenuTests() {
        this.dependencies = new HamburgerMenuDependencies();
    }

    @FrameworkAnnotation(authors = {"Rinaldo"}, categories = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void navigateToTabletsPageViaHamburgerMenuTest(Map<String, String> data) {

        dependencies.HomePage()
                .openAllCategoriesHamburgerMenu();

        String pageTitle = dependencies.HamburgerMenuPage()
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

        dependencies.HomePage()
                .openAllCategoriesHamburgerMenu();

        String pageTitle = dependencies.HamburgerMenuPage()
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

        dependencies.HomePage()
                .openAllCategoriesHamburgerMenu();

        String pageTitle = dependencies.HamburgerMenuPage()
                .selectHamburgerMenuOption(data.get("menuoption"))
                .selectHamburgerMenuSubOption(data.get("submenuoption"))
                .getPageTitle();

        assertThat(pageTitle)
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .containsIgnoringCase(data.get("submenuoption"));
    }

    @FrameworkAnnotation(authors = {"Rinaldo"}, categories = {CategoryType.SANITY})
    @Test
    public void verifyAmazonHomePageTitle(Map<String, String> data) {
        String pageTitleNew = dependencies.HomePage()
                .openAllCategoriesHamburgerMenu()
                .getPageTitle();

        /* String pageTitle = new HomePage()
                .openAllCategoriesHamburgerMenu()
                .getPageTitle(); */

        assertThat(pageTitleNew)
                .isNotBlank()
                .isNotEmpty()
                .isNotNull();
    }

}
