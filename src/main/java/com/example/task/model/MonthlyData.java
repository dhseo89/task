package com.example.task.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Table(name="monthly_data")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonthlyData {
	
	private String line;
	@Id
	private long no;
	private String station;
	private long jan;
	private long feb;
	private long mar;
	private long apr;
	private long may;
	private long jun;
	private long jul;
	private long aug;
	private long sep;	
	private long oct;
	private long nov;
	private long dec;	
	

}
