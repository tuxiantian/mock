工作中在本地调试项目时遇到需要调用外系统的接口的需求，由于网络不通或外系统接口暂未发布的情况，导致本地调试受阻。  
在t_intf_mock_data表中配置接口编码和对应的模拟报文。  
调用示例如下  
http://127.0.0.1:80/mock/data?intfCode=qryCustStateInfo  
weservice的调用示例如下  
http://127.0.0.1/services/mockService?wsdl
```$xslt
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:wsc="http://wsConfig.mock.com">
   <soapenv:Header/>
   <soapenv:Body>
      <wsc:invoke>
         <!--Optional:-->
         <intfCode>IOM_SlowOrder</intfCode>
         <!--Optional:-->
         <tranId>
         	1
         </tranId>
      </wsc:invoke>
   </soapenv:Body>
</soapenv:Envelope>
```
切换数据源配置需要改下面2个地方  
- applicationContext.xml里面的sqlSessionFactory的dataSource
- db.properties里面的dbType