package com.rdb.tests;

import com.rdb.annotations.FrameworkAnnotation;
import com.rdb.dependencies.HeaderDependencies;
import com.rdb.dependencies.IHeaderDependencies;
import com.rdb.enums.CategoryType;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class AmazonHeaderTests extends BaseTest {

    private final IHeaderDependencies dependencies;

    private AmazonHeaderTests() {
        this.dependencies = new HeaderDependencies();
    }

    @FrameworkAnnotation(authors = {"Hrishi"}, categories = {CategoryType.SMOKE})
    @Test
    public void verifyAmazonHomePageHeaderLogo(Map<String, String> data) {
        boolean isLogoPresent = dependencies.HomePage()
                .isAmazonHeaderLogoPresent();

        assertThat(isLogoPresent)
                .isTrue();
    }

    @FrameworkAnnotation(authors = {"Pankaj"}, categories = {CategoryType.REGRESSION})
    @Test
    public void searchForproductWithName(Map<String, String> data) {
        String pageTitle = dependencies.HeaderPage()
                .searchForProduct(data.get("productname"))
                .getPageTitle();

        assertThat(pageTitle)
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .containsIgnoringCase(data.get("productname"));
    }
}
