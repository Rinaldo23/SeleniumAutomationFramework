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

    @DataProvider(name = "getData", parallel = true)
    public static Object[] getData(Method method) {

        String methodName = method.getName();

        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getDataProviderSheetname());
        }

        List<Map<String, String>> smallList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(methodName) && list.get(i).get("execute").equalsIgnoreCase("yes")) {
                smallList.add(list.get(i));
            }
        }

        return smallList.toArray();
    }
}
