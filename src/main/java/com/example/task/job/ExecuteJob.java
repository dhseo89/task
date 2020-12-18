package com.example.task.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecuteJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jm = context.getJobDetail().getJobDataMap();
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 hh시mm분ss초");
		String curDate = sdf1.format(date);
		
		log.info("========ExecuteJob Quartz!!!========= "+jm.get("taskId"));
		log.info("Start time >>>>>>>>> {}", curDate);
	}
}
