package com.example.task.service;

import java.util.List;

import com.example.task.model.MonthlyDataModel;

public interface MonthlyDao {
	  public void insert(List<? extends MonthlyDataModel> monData);
	}
