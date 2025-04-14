package com.rdb.utils;

import com.rdb.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private static List<Map<String, String>> list = new ArrayList<>();

    private DataProviderUtils() {
    }

    @DataProvider(name = "getData")
    public static Object[] getData(Method method) {

        String methodName = method.getName();

        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getDataProviderSheetname());
        }

        List<Map<String, String>> smallList = new ArrayList<>();

        for (Map<String, String> map : list) {
            if (map.get("testname").equalsIgnoreCase(methodName) && map.get("execute").equalsIgnoreCase("yes")) {
                smallList.add(map);
            }
        }

        return smallList.toArray();
    }
}
