工作中在本地调试项目时遇到需要调用外系统的接口的需求，由于网络不通或外系统接口暂未发布的情况，导致本地调试受阻。
在t_intf_mock_data表中配置接口编码和对应的模拟报文。
调用示例如下
http://127.0.0.1:80/mock/data?intfCode=qryCustStateInfo