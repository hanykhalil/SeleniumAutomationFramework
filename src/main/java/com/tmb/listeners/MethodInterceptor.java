package com.tmb.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.util.ExcelUtil;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
	List<Map<String, String>> list=	ExcelUtil.getDataFromExcel("RUNMANAGER");
	System.out.println(list);
	List<IMethodInstance> result = new ArrayList<>();
	System.out.println("List size"+list.size());
	System.out.println("Method "+methods.size());
	System.out.println(list.get(0).get("testname"));
	for(int i=0;i<methods.size();i++) {
		for(int j=0;j<list.size();j++) {
			if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))) {
				if(list.get(j).get("execute").equalsIgnoreCase("yes")) {
					result.add(methods.get(i));
				}
			}
		}
	}
		return result;
	}

}
