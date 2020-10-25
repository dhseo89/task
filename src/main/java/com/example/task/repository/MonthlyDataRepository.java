package com.example.task.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.task.model.MonthlyData;
import com.example.task.model.ResultData;

@Repository
public interface MonthlyDataRepository extends JpaRepository <MonthlyData, Long> {

	@Transactional
	@Query(value="select * from\r\n" + 
			"	(select \r\n" + 
			"		line, \r\n" + 
			"		station,\r\n" + 
			"		greatest(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec) - least(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec) as gap\r\n" + 
			"	from monthly_data md\r\n" + 
			"	order by gap desc) a\r\n" + 
			"limit 1;	\r\n" + 
			"\r\n" + 
			"select\r\n" + 
			"	mon ||'월' as \"month\",\r\n" + 
			"	cnt,\r\n" + 
			"	line,\r\n" + 
			"	station\r\n" + 
			"from\r\n" + 
			"(\r\n" + 
			"	(select \r\n" + 
			"		line,\r\n" + 
			"		station,\r\n" + 
			"		row_number() over(partition by mon order by cnt) ranking,\r\n" + 
			"		mon,\r\n" + 
			"		cnt\r\n" + 
			"	from\r\n" + 
			"		(select line,\r\n" + 
			"			   station,\r\n" + 
			"			   unnest(array[1,2,3,4,5,6,7,8,9,10,11,12]) as mon,\r\n" + 
			"			   unnest(array[jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,\"dec\"]) as cnt\r\n" + 
			"		from monthly_data) a\r\n" + 
			"	)\r\n" + 
			") b\r\n" + 
			"where ranking = 1\r\n" + 
			"order by mon", nativeQuery=true)
	public List<ResultData> getMonthlyMinData();

	@Transactional
	@Query(value="select line, station, gap from\r\n" + 
			"	(select \r\n" + 
			"		line, \r\n" + 
			"		station,\r\n" + 
			"		greatest(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec) - least(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec) as gap\r\n" + 
			"	from monthly_data md\r\n" + 
			"	order by gap desc) a\r\n" + 
			"limit 1", nativeQuery=true)
	public ResultData getMostMonGapData();

}
