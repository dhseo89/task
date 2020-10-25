package com.example.task.util;

import org.springframework.batch.item.ItemProcessor;

import com.example.task.model.MonthlyDataModel;

public class MonthlyProcessor implements ItemProcessor<MonthlyDataModel, MonthlyDataModel> {

	@Override
	public MonthlyDataModel process(MonthlyDataModel data) throws Exception {

		final String line = data.getLine();
		final long no = data.getNo();
		final String station = data.getStation();
		final String jan = data.getJan();
		final String feb = data.getFeb();
		final String mar = data.getMar();
		final String apr = data.getApr();
		final String may = data.getMay();
		final String jun = data.getJun();	
		final String jul = data.getJul();
		final String aug = data.getAug();
		final String sep = data.getSep();
		final String oct = data.getOct();
		final String nov = data.getNov();
		final String dec = data.getDec();		

		final MonthlyDataModel fixedData = new MonthlyDataModel(line, no, station, jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
		return fixedData;
	}
}