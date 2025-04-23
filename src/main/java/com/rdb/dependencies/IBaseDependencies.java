package com.rdb.dependencies;

import com.rdb.pages.HomePage;
import com.rdb.pages.interactions.InteractionService;

public interface IBaseDependencies {

    InteractionService Interactions();

    HomePage HomePage();
}
