package com.example.task.util;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.task.model.MonthlyDataModel;
import com.example.task.service.MonthlyDao;

public class MonthlyWriter implements ItemWriter<MonthlyDataModel> {
	 
	  private final MonthlyDao monthlyDao;
	  
	  public MonthlyWriter(MonthlyDao monthlyDao) {
	    this.monthlyDao = monthlyDao;
	  }
	 
	  @Override
	  public void write(List<? extends MonthlyDataModel> monthlyDatas) throws Exception {
		  monthlyDao.insert(monthlyDatas);
	  }
	}