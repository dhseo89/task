package com.example.task.scheduler;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.task.job.ExecuteJob;

@Service
public class QuartzServiceImpl implements QuartzService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	Scheduler scheduler;

	@PostConstruct
	public void ready() throws SchedulerException {
		scheduler = new StdSchedulerFactory().getScheduler();
	}

	@Override
	public String quartzStart(String id, String grpId, int sec) throws SchedulerException {
		JobKey jobKey = new JobKey(id, grpId);
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(id, grpId == null ? scheduler.DEFAULT_GROUP : grpId)
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(sec == 0 ? 3 : sec)).build();
		
		JobDataMap jobDataMap = new JobDataMap(); 
		jobDataMap.put("taskId", id);
		jobDataMap.put("grpId", grpId);
		jobDataMap.put("sec", String.valueOf(sec)+"초");
		
		JobDetail jobDetail = JobBuilder.newJob(ExecuteJob.class).usingJobData(jobDataMap).withIdentity(id, grpId).build();
		if(!scheduler.checkExists(jobKey)) { //존재하지 않을 경우 스케줄러 생성
			logger.info("쿼츠가 존재하지 않아 새로 생성합니다... "+ id, grpId);
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		}else {
			scheduler.start();
		}
		return jobDetail.toString();
	}
}
