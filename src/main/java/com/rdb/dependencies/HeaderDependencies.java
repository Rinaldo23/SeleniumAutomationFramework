package com.rdb.dependencies;

import com.rdb.interactions.Interactions;
import com.rdb.pages.HeaderPage;
import com.rdb.pages.HomePage;

public class HeaderDependencies implements IHeaderDependencies {

    private final Interactions interactions;
    private final HomePage homePage;
    private final HeaderPage headerPage;

    public HeaderDependencies() {
        this.interactions = new Interactions();
        this.headerPage = new HeaderPage(interactions);
        this.homePage = new HomePage(interactions);
    }

    @Override
    public HomePage HomePage() {
        return homePage;
    }

    @Override
    public HeaderPage HeaderPage() {
        return headerPage;
    }
}
