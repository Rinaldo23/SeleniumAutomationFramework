package com.rdb.listeners;

import com.rdb.constants.FrameworkConstants;
import com.rdb.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<IMethodInstance> result = new ArrayList<>();
        List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getTestDataSheetname());
        //System.out.println(list);

        for (IMethodInstance method : methods) {
            for (Map<String, String> map : list) {
                if (method.getMethod().getMethodName().equalsIgnoreCase(map.get("testname"))
                        && map.get("execute").equalsIgnoreCase("yes")) {

                    method.getMethod().setDescription(map.get("testdescription"));
                    method.getMethod().setPriority(Integer.parseInt(map.get("priority")));
                    method.getMethod().setInvocationCount(Integer.parseInt(map.get("count")));
                    result.add(method);
                }
            }
        }

        return result;
    }
}
