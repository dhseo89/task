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

import com.example.task.model.MonthlyDataModel;

@Repository
public class MonthlyDataDaoImpl extends JdbcDaoSupport implements MonthlyDao {
 
  @Autowired
  DataSource dataSource;
 
  @PostConstruct
  private void initialize() {
    setDataSource(dataSource);
  }
 
  @Override
  public void insert(List<? extends MonthlyDataModel> data) {
    String sql = "INSERT INTO monthly_data " + "(line, no, station, jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
      public void setValues(PreparedStatement ps, int i) throws SQLException {
    	MonthlyDataModel monData = data.get(i);
    	ps.setString(1, monData.getLine());
        ps.setLong(2, monData.getNo());
        ps.setString(3, monData.getStation());
        long jan = Long.parseLong(monData.getJan().replace(",", ""));
        long feb = Long.parseLong(monData.getFeb().replace(",", ""));
        long mar = Long.parseLong(monData.getMar().replace(",", ""));
        long apr = Long.parseLong(monData.getApr().replace(",", ""));
        long may = Long.parseLong(monData.getMay().replace(",", ""));
        long jun = Long.parseLong(monData.getJun().replace(",", ""));
        long jul = Long.parseLong(monData.getJul().replace(",", ""));
        long aug = Long.parseLong(monData.getAug().replace(",", ""));
        long sep = Long.parseLong(monData.getSep().replace(",", ""));
        long oct = Long.parseLong(monData.getOct().replace(",", ""));
        long nov = Long.parseLong(monData.getNov().replace(",", ""));
        long dec = Long.parseLong(monData.getDec().replace(",", ""));
        ps.setLong(4, jan);
        ps.setLong(5, feb);
        ps.setLong(6, mar);
        ps.setLong(7, apr);
        ps.setLong(8, may);     
        ps.setLong(9, jun);
        ps.setLong(10, jul);
        ps.setLong(11, aug);
        ps.setLong(12, sep);
        ps.setLong(13, oct);
        ps.setLong(14, nov);
        ps.setLong(15, dec);         
      }
 
      public int getBatchSize() {
        return data.size();
      }
    });
 
  }
}