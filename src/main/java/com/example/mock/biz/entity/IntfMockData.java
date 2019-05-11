package com.example.mock.biz.entity;


public class IntfMockData  {
	//接口编码
	private String intfCode;
	//接口响应报文
	private String respData;

    public String getIntfCode(){
    	return intfCode;
    }

    public void setIntfCode(String intfCode){
    	this.intfCode = intfCode;
    }



	public String getRespData(){
		return respData;
	}

	public void setRespData(String respData){
        this.respData = respData;
    }

}