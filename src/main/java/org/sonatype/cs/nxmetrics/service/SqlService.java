package org.sonatype.cs.nxmetrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.sonatype.cs.nxmetrics.util.SqlStatement;

@Service
public class SqlService {

    @Autowired 
    private JdbcTemplate jtm;

    public void LoadSuccessMetrics(String csvFile) {
		String stmt = SqlStatement.MetricsTable + "('" + csvFile + "')";	
		jtm.execute(stmt);
	}
    
}
