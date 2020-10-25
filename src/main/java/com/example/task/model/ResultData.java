package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData {
	
	private String line;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private long no;
	private String station;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private long gap;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private long cnt;
	private String month;
}
