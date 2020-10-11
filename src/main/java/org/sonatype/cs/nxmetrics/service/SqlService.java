package org.sonatype.cs.nxmetrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import org.sonatype.cs.nxmetrics.model.DbRow;

@Service
public class SqlService {

    @Autowired 
    private JdbcTemplate jtm;

    public void executeSql(String stmt) {
      jtm.execute(stmt);
    }
    
    public List<DbRow> executeSql2(String stmt) {
      return jtm.query(stmt, new BeanPropertyRowMapper<>(DbRow.class));  
    }
    
}
