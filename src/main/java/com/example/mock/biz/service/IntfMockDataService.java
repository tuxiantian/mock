package com.example.mock.biz.service;


import com.example.mock.biz.mapper.IntfMockDataMapper;
import com.example.mock.biz.entity.IntfMockData;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
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
		return intfMockData.getRespData();
	}
}