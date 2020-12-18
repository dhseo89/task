package com.example.task.controller;

import javax.annotation.PostConstruct;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.scheduler.QuartzService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/task/quartz")
@Api(tags = { "3.quartz 스케줄러" }, value = "quartz 스케줄러")
public class QuartzController {

	@Autowired
	QuartzService quartzService;
	
	@ApiOperation(value = "쿼츠를 시작한다", notes = "쿼츠 시작, 없으면 만들어서 시작")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "jobId", required = true, dataType = "string", paramType = "query", defaultValue = "test1"),
        @ApiImplicitParam(name = "grpId", value = "groupId", required = false, dataType = "string", paramType = "query", defaultValue = "grp1"),
        @ApiImplicitParam(name = "sec", value = "시간(초)", required = false, dataType = "string", paramType = "query")
    })	
	@GetMapping("/start")
	public String quartzStart(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "grpId", required = false) String grpId,
			@RequestParam(value = "sec", required = false) int sec) throws Exception {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("쿼츠 시작 요청... id "+id + " grpId "+ grpId + " sec "+ sec);
		return quartzService.quartzStart(id, grpId, sec);
	}
}
