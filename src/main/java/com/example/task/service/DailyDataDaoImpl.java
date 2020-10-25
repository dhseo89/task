package com.example.task.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.task.model.DailyData;

@Repository
public class DailyDataDaoImpl extends JdbcDaoSupport implements DailyDao {
 
  @Autowired
  DataSource dataSource;
 
  @PostConstruct
  private void initialize() {
    setDataSource(dataSource);
  }
 
  @Override
  public void insert(List<? extends DailyData> data) {
    String sql = "INSERT INTO daily_data " + "(no, station, use_num) VALUES (?, ?, ?)";
    getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
      public void setValues(PreparedStatement ps, int i) throws SQLException {
    	DailyData dailyData = data.get(i);
        ps.setLong(1, dailyData.getNo());
        ps.setString(2, dailyData.getStation());
        ps.setLong(3, dailyData.getUseNum());
      }
 
      public int getBatchSize() {
        return data.size();
      }
    });
 
  }
}