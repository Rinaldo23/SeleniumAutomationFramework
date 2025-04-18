package com.rdb.dependencies;

import com.rdb.interactions.Interactions;
import com.rdb.pages.HomePage;

public interface IBaseDependencies {

    Interactions interactions();

    HomePage HomePage();
}
