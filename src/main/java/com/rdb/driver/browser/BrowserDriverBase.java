package com.rdb.driver.browser;

public abstract class BrowserDriverBase implements IBrowserDriver {

    private boolean enableHeadlessExecution;

    @Override
    public boolean isEnableHeadlessExecution() {
        return enableHeadlessExecution;
    }

    @Override
    public void setEnableHeadlessExecution(boolean enableHeadlessExecution) {
        this.enableHeadlessExecution = enableHeadlessExecution;
    }
}
