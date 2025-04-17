package com.rdb.dependencies;

import com.rdb.pages.HamburgerMenuPage;
import com.rdb.pages.HomePage;
import com.rdb.pages.TabletsPage;

public interface IHamburgerMenuDependencies {

    HomePage HomePage();

    HamburgerMenuPage HamburgerMenuPage();

    TabletsPage TabletsPage();

}
