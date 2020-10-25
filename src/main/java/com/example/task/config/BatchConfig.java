package com.example.task.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.task.model.DailyData;
import com.example.task.model.MonthlyDataModel;
import com.example.task.service.DailyDao;
import com.example.task.service.MonthlyDao;
import com.example.task.util.Listener;
import com.example.task.util.MonthlyProcessor;
import com.example.task.util.MonthlyReader;
import com.example.task.util.MonthlyWriter;
import com.example.task.util.Processor;
import com.example.task.util.Reader;
import com.example.task.util.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
 
  @Autowired
  public JobBuilderFactory jobBuilderFactory;
 
  @Autowired
  public StepBuilderFactory stepBuilderFactory;
 
  @Autowired
  public DailyDao dailyDao;
  
  @Autowired
  public MonthlyDao monthlyDao;  
 
  @Bean
  public Job job() {
    return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener())
        .flow(step1()).next(step2()).end().build();
  }
 
  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1").<DailyData, DailyData>chunk(2)
        .reader(Reader.reader("daily_data.csv"))
        .processor(new Processor()).writer(new Writer(dailyDao)).build();
  }
  
  @Bean
  public Step step2() {
    return stepBuilderFactory.get("step2").<MonthlyDataModel, MonthlyDataModel>chunk(10)
        .reader(MonthlyReader.reader("monthly_data.csv"))
        .processor(new MonthlyProcessor()).writer(new MonthlyWriter(monthlyDao)).build();
  }  
}