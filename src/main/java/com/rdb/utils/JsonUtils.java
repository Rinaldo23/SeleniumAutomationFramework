package com.rdb.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdb.constants.FrameworkConstants;
import com.rdb.enums.ConfigProperties;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JsonUtils {

    private static Map<String, String> jSONCONGIFMAP;

    static {
        try {
            jSONCONGIFMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonConfigFilePath()), new TypeReference<HashMap<String, String>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JsonUtils() {
    }

    public static String getValue(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(jSONCONGIFMAP.get(key.name().toLowerCase()))) {
            throw new Exception("Property key " + key + " not found in config.properties File.");
        }
        return jSONCONGIFMAP.get(key.name().toLowerCase());
    }
}
