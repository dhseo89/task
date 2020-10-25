package com.example.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.mapper.DailyDataMapper;
import com.example.task.mapper.MonthlyDataMapper;
import com.example.task.model.DailyData;
import com.example.task.model.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/task/general")
@Api(tags= {"2.데이터  조회 API"},value = "데이터 조회")
public class GeneralTaskController {	
	
	@Autowired
	private DailyDataMapper dailyMapper;
	
	@Autowired
	private MonthlyDataMapper monMapper;
	
	@ApiOperation(value = "일평균 인원이 가장 많은 상위 10개의 역 명과 인원 수", notes = "상위 10개의 역 명과 인원 수")
	@GetMapping("/getDailyData")
	public List<DailyData> getDailyDataTop10() throws Exception {
		return dailyMapper.getSelectTop10();
	}
	
	@ApiOperation(value = "월 인원수 평균이 가장 낮은 역 명과 인원수", notes = "평균이 가장 낮은 역 명과 인원수")
	@GetMapping("/getMonthlyMinData")
	public List<ResultData> getMonthlyMinData() throws Exception {
		return monMapper.getMonthlyMinData();
	}
	
	@ApiOperation(value = "월 인원수 최대 최소의 차이가 가장 큰 역 명", notes = "최대 최소의 차이가 가장 큰 역")
	@GetMapping("/getMostMonGapData")
	public ResultData getMostGapMonData() throws Exception {
		return monMapper.getMostGapData();
	}	
}
