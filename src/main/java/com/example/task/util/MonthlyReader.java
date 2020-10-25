package com.example.task.util;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.example.task.model.MonthlyDataModel;

public class MonthlyReader {
	public static FlatFileItemReader<MonthlyDataModel> reader(String path) {
		FlatFileItemReader<MonthlyDataModel> reader = new FlatFileItemReader<MonthlyDataModel>();
		reader.setEncoding("euc-kr");

		reader.setResource(new ClassPathResource(path));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}

	private static LineMapper<MonthlyDataModel> lineMapper() {
		DefaultLineMapper<MonthlyDataModel> lineMapper = new DefaultLineMapper<MonthlyDataModel>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setQuoteCharacter('"'); //" 문자 제거
		lineTokenizer.setNames(new String[] {"line", "no", "statition", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"});
		lineTokenizer.setIncludedFields(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
		BeanWrapperFieldSetMapper<MonthlyDataModel> fieldsMapper = new BeanWrapperFieldSetMapper<MonthlyDataModel>(); 
		fieldsMapper.setTargetType(MonthlyDataModel.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldsMapper);
		return lineMapper;
	}
}