package org.sonatype.cs.nxmetrics.service;

import java.util.ArrayList;
import java.util.List;

import org.sonatype.cs.nxmetrics.model.DbRow;
import org.sonatype.cs.nxmetrics.model.Metric;
import org.sonatype.cs.nxmetrics.model.Mttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataService  {
    @Autowired 
    private JdbcTemplate jtm;
    
    @Autowired
    private DataRepositoryService repository;

    public void runSqlLoad(String stmt) {
        jtm.execute(stmt);
    }
      
    public List<DbRow> runSql(String stmt) {
        return jtm.query(stmt, new BeanPropertyRowMapper<>(DbRow.class));  
    }
  
    public List<Mttr> runSqlMttr(String stmt) {
        return jtm.query(stmt, new BeanPropertyRowMapper<>(Mttr.class));  
    }

    public List<Metric> findAllMetrics() {
        Iterable<Metric> it = repository.findAll();
        ArrayList<Metric> metrics = new ArrayList<Metric>();
        it.forEach(e -> metrics.add(e));
        return metrics;
    }
}
