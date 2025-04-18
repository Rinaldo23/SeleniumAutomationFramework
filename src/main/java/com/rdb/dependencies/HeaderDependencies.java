package com.rdb.dependencies;

import com.rdb.pages.HeaderPage;

public class HeaderDependencies extends BaseDependencies implements IHeaderDependencies {

    private final HeaderPage headerPage;

    public HeaderDependencies() {
        super(); // calls BaseDependencies constructor
        this.headerPage = new HeaderPage(interactions);
    }

    @Override
    public HeaderPage HeaderPage() {
        return headerPage;
    }
}
