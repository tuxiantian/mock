package com.example.mock.wsConfig;

import com.example.mock.biz.service.IntfMockDataService;
import com.example.mock.wsConfig.MockWebservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "mockService", // 【对外发布的服务名 】：需要见名知意
        targetNamespace = "http://wsConfig.mock.com", // 【名称空间】：【实现类包名的反缀】 www.namespace.com
        endpointInterface = "com.example.mock.wsConfig.MockWebservice")
@Component
public class MockWebserviceImpl implements MockWebservice {
    @Autowired
    private IntfMockDataService intfMockDataService;


    @Override
    public String invoke(String intfCode, String tranId) {
        return intfMockDataService.findByIntfCode(intfCode,tranId);
    }
}
