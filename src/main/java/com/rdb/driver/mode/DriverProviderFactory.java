package com.rdb.driver.mode;

import com.rdb.enums.ConfigProperties;
import com.rdb.utils.PropertyUtils;

public final class DriverProviderFactory {

    private DriverProviderFactory() {
    }

    public static IDriverProvider getProvider() {
        String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);

        return switch (runmode.toLowerCase()) {
            case "local" -> new LocalDriverProvider();
            case "remote" -> new RemoteDriverProvider();
            default -> throw new IllegalArgumentException("Unsupported run mode: " + runmode);
        };
    }
}
