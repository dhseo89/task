package com.example.task.util;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.task.model.DailyData;
import com.example.task.service.DailyDao;

public class Writer implements ItemWriter<DailyData> {
	 
	  private final DailyDao dailyDao;
	  
	  public Writer(DailyDao dailyDao) {
	    this.dailyDao = dailyDao;
	  }
	 
	  @Override
	  public void write(List<? extends DailyData> dailyDatas) throws Exception {
		  dailyDao.insert(dailyDatas);
	  }
	}