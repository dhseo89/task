package com.example.task.scheduler;

import org.quartz.SchedulerException;

public interface QuartzService {

	String quartzStart(String id, String grpId, int sec) throws SchedulerException;
}
