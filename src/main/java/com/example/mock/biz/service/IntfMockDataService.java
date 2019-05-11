package com.example.mock.biz.service;


import com.alibaba.fastjson.JSON;
import com.example.mock.biz.enums.ResponseDataType;
import com.example.mock.biz.mapper.IntfMockDataMapper;
import com.example.mock.biz.entity.IntfMockData;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* Created by creator
*/
@Service
@Transactional
@Log4j2
public class IntfMockDataService {

	private static final Logger logger = LoggerFactory.getLogger(IntfMockDataService.class);

	@Autowired
	private IntfMockDataMapper mapper;


    public String findByIntfCode(String intfCode,String tranId){
        IntfMockData intfMockData = this.mapper.findByIntfCode(intfCode,tranId);
        if (intfMockData==null){
        	return String.format("找不到配置的模拟报文，你可能还没有配置intfCode=%s,tranId=%s的模拟报文哟",intfCode,tranId);
		}
		log.info("接口编码是{},业务流水是{}，模拟报文是{}",intfCode,tranId,intfMockData.getRespData());
		try {
			if (intfMockData.getType()!=null && ResponseDataType.JSON.getVal()==intfMockData.getType()) {
				JSON.parse(intfMockData.getRespData());
			}
		} catch (Exception e) {
			log.error("模拟报文不能解析为json",e);
			return String.format("模拟报文不能解析为json，请检查你配置intfCode=%s,tranId=%s的模拟报文",intfCode,tranId);
		}
		try {
			if (intfMockData.getType()!=null && ResponseDataType.XML.getVal()==intfMockData.getType()){
				DocumentHelper.parseText(intfMockData.getRespData());
			}
			return String.format("模拟报文不能解析为xml，请检查你配置intfCode=%s,tranId=%s的模拟报文",intfCode,tranId);
		}catch (Exception e){
			log.error("模拟报文不能解析为xml",e);
		}
		return intfMockData.getRespData();
	}
}