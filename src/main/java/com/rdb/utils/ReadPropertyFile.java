package com.rdb.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile() {
    }

    public static String getValue(String key) throws Exception {

        String value;
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config/config.properties");
        Properties prop = new Properties();
        prop.load(fis);

        value = prop.getProperty(key);
        if (Objects.isNull(value)) {
            throw new Exception("Property key " + key + " not found in config.properties File.");
        }
        fis.close();
        return value;
    }
}
