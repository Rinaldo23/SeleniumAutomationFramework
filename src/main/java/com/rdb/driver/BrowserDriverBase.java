package com.rdb.driver;

public abstract class BrowserDriverBase implements IBrowserDriver {

    private boolean enableHeadlessExecution;
    private boolean setRemoteExecutionMode;

    @Override
    public boolean isEnableHeadlessExecution() {
        return enableHeadlessExecution;
    }

    @Override
    public void setEnableHeadlessExecution(boolean enableHeadlessExecution) {
        this.enableHeadlessExecution = enableHeadlessExecution;
    }

    @Override
    public boolean isRemoteExecution() {
        return setRemoteExecutionMode;
    }

    @Override
    public void setRemoteExecution(boolean setRemoteExecutionMode) {
        this.setRemoteExecutionMode = setRemoteExecutionMode;
    }
}
