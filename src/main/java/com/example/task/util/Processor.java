package com.example.task.util;

import org.springframework.batch.item.ItemProcessor;

import com.example.task.model.DailyData;

public class Processor implements ItemProcessor<DailyData, DailyData> {

	@Override
	public DailyData process(DailyData data) throws Exception {

		final long id = data.getNo();
		final String station = data.getStation();
		final long useNum = data.getUseNum();

		final DailyData fixedData = new DailyData(id, station, useNum);
		return fixedData;
	}
}