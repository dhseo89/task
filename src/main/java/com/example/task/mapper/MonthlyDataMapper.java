package com.example.task.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.task.model.ResultData;

@Mapper
public interface MonthlyDataMapper {
	
	List<ResultData> getMonthlyMinData();
	
	ResultData getMostGapData();
}
