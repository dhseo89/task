package com.example.task.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/task/batch")
@Api(tags= {"1.데이터 삽입 API"},value = "데이터 일괄삽입")
public class BatchTaskController {
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@ApiOperation(value = " 파일을 읽어 데이터를 삽입", notes = "데이터 삽입")
	@PostMapping("/execute")
	public String readFileToDb() throws Exception {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncher.run(job, jobParameters);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "Task is finished. Check the detail infomation.";
	}
}
