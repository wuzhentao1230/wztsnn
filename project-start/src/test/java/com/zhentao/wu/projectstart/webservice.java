package com.zhentao.wu.projectstart;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.StringUtils;

public class webservice {
    public static void main(String[] args) {
        // 指定调用WebService的URL（这里是我们发布后点击HelloWorld）
        String url = "http://localhost:8080/services/HelloWorld?wsdl";
        //调用的方法
        String method = "add";
        //调用方法的参数列表
        Object[] parms = new Object[]{2.0,3.0};
        webservice calculateClient = new webservice();
        //调用方法
        String svrAddResult = calculateClient.CallMethod(url, method, parms);

        System.out.println(svrAddResult);

        String svrMinusResult = calculateClient.CallMethod(url, "minus", new Object[]{5.0,2.0});
        String svrMultiplyResult = calculateClient.CallMethod(url, "multiply", new Object[]{2.0,3.0});
        String svrDivideResult = calculateClient.CallMethod(url, "divide", new Object[]{8.0,5.0});
        String svrPowerResult = calculateClient.CallMethod(url, "power", new Object[]{5.0});
        String svrSqrtResult = calculateClient.CallMethod(url, "sqrt", new Object[]{9.0});

        System.out.println("5.0 - 2.0 is " + svrMinusResult);
        System.out.println("2.0 * 3.0 is " + svrMultiplyResult);
        System.out.println("8.0 - 5.0 is " + svrDivideResult);
        System.out.println("5.0^2 is " + svrPowerResult);
        System.out.println("9.0^(1/2) is " + svrSqrtResult);
    }

    //实现WebService上发布的服务调用
    public String CallMethod(String url, String method, Object[] args) {
        String result = null;

        if(StringUtils.isEmpty(url)) {
            return "url地址为空";
        }
        if(StringUtils.isEmpty(method)) {
            return "method地址为空";
        }

        Call rpcCall = null;

        try {
            //实例websevice调用实例
            Service webService = new Service();
            rpcCall = (Call) webService.createCall();
            rpcCall.setTargetEndpointAddress(new java.net.URL(url));
            rpcCall.setOperationName(method);

            //执行webservice方法

            double rslt = (double) rpcCall.invoke(args);
            result = String.valueOf(rslt);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
