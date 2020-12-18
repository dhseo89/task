package com.example.task.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SchedulerConfig {
	@Bean
	public void startQuartz() throws SchedulerException {
		log.info("시작시에 쿼츠를 시작합니다....");
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
	}
}
