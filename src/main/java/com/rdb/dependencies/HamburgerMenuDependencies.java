package com.rdb.dependencies;

import com.rdb.interactions.Interactions;
import com.rdb.pages.HamburgerMenuPage;
import com.rdb.pages.HomePage;

public class HamburgerMenuDependencies implements IHamburgerMenuDependencies {

    private final Interactions interactions;
    private final HomePage homePage;
    private final HamburgerMenuPage hamburgerMenuPage;

    public HamburgerMenuDependencies() {
        this.interactions = new Interactions();
        this.hamburgerMenuPage = new HamburgerMenuPage(interactions);
        this.homePage = new HomePage(interactions);
    }

    @Override
    public HomePage HomePage() {
        return homePage;
    }

    @Override
    public HamburgerMenuPage HamburgerMenuPage() {
        return hamburgerMenuPage;
    }
    
}
