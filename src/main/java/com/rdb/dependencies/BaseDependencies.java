package com.rdb.dependencies;

import com.rdb.interactions.Interactions;
import com.rdb.pages.HomePage;

public class BaseDependencies implements IBaseDependencies {

    /**
     * - Introduced IBaseDependencies interface to define common dependencies
     * - Created BaseDependencies class to initialize shared components like Interactions and HomePage
     * - Refactored HeaderDependencies and HamburgerMenuDependencies to extend BaseDependencies
     * - Improved test class readability by reducing duplication and enhancing maintainability
     */

    /* protected allows subclasses to use these objects */
    protected final Interactions interactions;
    protected final HomePage homePage;

    public BaseDependencies() {
        this.interactions = new Interactions();
        this.homePage = new HomePage(interactions);
    }

    @Override
    public Interactions interactions() {
        return interactions;
    }

    @Override
    public HomePage HomePage() {
        return homePage;
    }
}
