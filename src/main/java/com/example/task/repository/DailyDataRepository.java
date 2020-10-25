package com.example.task.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.task.model.DailyData;

public interface DailyDataRepository extends JpaRepository<DailyData, Long> {

	@Transactional
	@Query(value="select station, use_num, no from \r\n" + 
			"	(	select station, use_num, no from daily_data\r\n" + 
			"		order by use_num desc\r\n" + 
			"	) a\r\n" + 
			"limit 10", nativeQuery=true)
	public List<DailyData> getDailyTop10();
}
