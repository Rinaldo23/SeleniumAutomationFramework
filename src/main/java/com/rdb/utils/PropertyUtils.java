package com.rdb.utils;

import com.rdb.constants.FrameworkConstants;
import com.rdb.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private static final Map<String, String> CONFIGMAP = new HashMap<>();
    private static final Properties prop = new Properties();

    // Eager Initialization
    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            prop.load(fis);

            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); // To remove the spaces at the end
            }

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*prop.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));  // --> Java 1.8+
    prop.forEach((key, value) -> CONFIGMAP.put(String.valueOf(key), String.valueOf(value)));  */                          // --> Java 1.8+

    private PropertyUtils() {
    }

    public static String getValue(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("Property key " + key + " not found in config.properties File.");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

    // Lazy Initialization
    /* public static String getValue(String key) throws Exception {

        String value;
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config/config.properties");
        prop.load(fis);

        value = prop.getProperty(key);

        if (Objects.isNull(value)) {
            throw new Exception("Property key " + key + " not found in config.properties File.");
        }
        fis.close();
        return value;
    }

     */
}
