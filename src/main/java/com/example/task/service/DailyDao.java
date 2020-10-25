package com.example.task.service;

import java.util.List;

import com.example.task.model.DailyData;

public interface DailyDao {
	  public void insert(List<? extends DailyData> dailData);
	}
