package com.example.task.util;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.example.task.model.DailyData;

public class Reader {
	public static FlatFileItemReader<DailyData> reader(String path) {
		FlatFileItemReader<DailyData> reader = new FlatFileItemReader<DailyData>();
		reader.setEncoding("euc-kr");
		
		reader.setResource(new ClassPathResource(path));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}

	private static LineMapper<DailyData> lineMapper() {
		DefaultLineMapper<DailyData> lineMapper = new DefaultLineMapper<DailyData>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] {"no", "station", "useNum"});
		lineTokenizer.setIncludedFields(new int[] {0, 1, 2});
		BeanWrapperFieldSetMapper<DailyData> fieldsMapper = new BeanWrapperFieldSetMapper<DailyData>(); 
		fieldsMapper.setTargetType(DailyData.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldsMapper);
		return lineMapper;
	}
}