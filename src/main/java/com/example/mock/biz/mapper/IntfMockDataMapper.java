package com.example.mock.biz.mapper;

import com.example.mock.biz.entity.IntfMockData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IntfMockDataMapper {
    IntfMockData findByIntfCode(@Param("intfCode") String intfCode);
}
