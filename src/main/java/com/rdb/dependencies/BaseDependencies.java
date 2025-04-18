package com.rdb.dependencies;

import com.rdb.pages.HomePage;
import com.rdb.pages.interactions.InteractionService;

public class BaseDependencies implements IBaseDependencies {

    /**
     * - Introduced IBaseDependencies interface to define common dependencies
     * - Created BaseDependencies class to initialize shared components like Interactions and HomePage
     * - Refactored HeaderDependencies and HamburgerMenuDependencies to extend BaseDependencies
     * - Improved test class readability by reducing duplication and enhancing maintainability
     */

    /* protected allows subclasses to use these objects */
    protected final InteractionService interactions;
    protected final HomePage homePage;

    public BaseDependencies() {
        this.interactions = new InteractionService();
        this.homePage = new HomePage(interactions);
    }

    @Override
    public InteractionService interactions() {
        return interactions;
    }

    @Override
    public HomePage HomePage() {
        return homePage;
    }
}
