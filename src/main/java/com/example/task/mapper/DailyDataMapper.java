package com.example.task.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.task.model.DailyData;

@Mapper
public interface DailyDataMapper {

	List<DailyData> getSelectTop10();
}
