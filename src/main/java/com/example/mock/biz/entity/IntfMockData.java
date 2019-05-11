package com.example.mock.biz.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntfMockData  {
	//接口编码
	private String intfCode;
	//1表示json,2表示xml
	private Integer type;
	//接口响应报文
	private String respData;


}