package com.rdb.dependencies;

import com.rdb.pages.HamburgerMenuPage;

public class HamburgerMenuDependencies extends BaseDependencies implements IHamburgerMenuDependencies {

    private final HamburgerMenuPage hamburgerMenuPage;

    public HamburgerMenuDependencies() {
        super();
        this.hamburgerMenuPage = new HamburgerMenuPage(interactions);
    }

    @Override
    public HamburgerMenuPage HamburgerMenuPage() {
        return hamburgerMenuPage;
    }

}
