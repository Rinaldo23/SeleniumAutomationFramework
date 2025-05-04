package com.rdb.dependencies;

import com.rdb.pages.HomePage;
import com.rdb.pages.interactions.InteractionServiceImpl;

public class BaseDependencies implements IBaseDependencies {

    /**
     * - Introduced IBaseDependencies interface to define common dependencies
     * - Created BaseDependencies class to initialize shared components like Interactions and HomePage
     * - Refactored HeaderDependencies and HamburgerMenuDependencies to extend BaseDependencies
     * - Improved test class readability by reducing duplication and enhancing maintainability
     */

    /* protected allows subclasses to use these objects */
    /* private final InteractionService interactions; */
    protected final HomePage homePage;
    protected final InteractionServiceImpl interactions;

    public BaseDependencies() {
        this.interactions = new InteractionServiceImpl();
        this.homePage = new HomePage(interactions);
    }

    @Override
    public HomePage HomePage() {
        return homePage;
    }
}
