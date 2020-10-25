package com.example.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author DongHwan
 * "3,364,130"식의 데이터를 변환하여 넣기 위해 추가
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyDataModel {
	
	private String line;
	private long no;
	private String station;
	private String jan;
	private String feb;
	private String mar;
	private String apr;
	private String may;
	private String jun;
	private String jul;
	private String aug;
	private String sep;	
	private String oct;
	private String nov;
	private String dec;	
}
