package org.sonatype.cs.nxmetrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqlService {

    @Autowired 
    private JdbcTemplate jtm;

    public void ExecuteSql(String stmt) {
      jtm.execute(stmt);
	  }
    
}
