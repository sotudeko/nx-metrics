package org.sonatype.cs.nxmetrics.service;

import java.util.ArrayList;
import java.util.List;

import org.sonatype.cs.nxmetrics.model.DbRow;
import org.sonatype.cs.nxmetrics.model.Metric;
import org.sonatype.cs.nxmetrics.util.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService  {

    @Autowired
    private DataRepositoryService repository;

    @Autowired
    private SqlService sqlService;

    public List<Metric> findAllMetrics() {
        Iterable<Metric> it = repository.findAll();
        ArrayList<Metric> metrics = new ArrayList<Metric>();
        it.forEach(e -> metrics.add(e));
        return metrics;
    }

    public void loadMetrics(String stmt){
        sqlService.executeSql(stmt);
    }

    public List<DbRow> findApplicationsOnboarded(){
        return sqlService.executeSql2(SqlStatement.ApplicationsOnboarded);
    }
    
}
