package com.example.mock.wsConfig;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "mockService", targetNamespace = "http://wsConfig.mock.com")
public interface MockWebservice {
    @WebMethod
    public @WebResult
    String invoke(@WebParam(name = "intfCode") String intfCode, @WebParam(name = "tranId") String tranId);
}
