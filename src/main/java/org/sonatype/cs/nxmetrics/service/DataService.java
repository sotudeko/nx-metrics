package org.sonatype.cs.nxmetrics.service;

import java.util.ArrayList;
import java.util.List;

import org.sonatype.cs.nxmetrics.model.DbRow;
import org.sonatype.cs.nxmetrics.model.Mttr;
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

    public List<DbRow> findMostScannedApplications(){
        return sqlService.executeSql2(SqlStatement.MostScannedApplications);
    }

    public List<DbRow> findNumberOfScans(){
        return sqlService.executeSql2(SqlStatement.NumberOfScans);
    }

    public List<DbRow> findNumberOfApplicationsScanned(){
        return sqlService.executeSql2(SqlStatement.NumberOfApplicationsScanned);
    }

    public List<DbRow> findOpenSecurityViolations(){
        return sqlService.executeSql2(SqlStatement.OpenSecurityViolations);
    }

    public List<DbRow> findDiscoveredSecurityViolations(){
        return sqlService.executeSql2(SqlStatement.DiscoveredSecurityViolations);
    }

    public List<DbRow> findFixedSecurityViolations(){
        return sqlService.executeSql2(SqlStatement.FixedSecurityViolations);
    }

    public List<DbRow> findWaivedSecurityViolations(){
        return sqlService.executeSql2(SqlStatement.WaivedSecurityViolations);
    }

    public List<DbRow> findOpenLicenseViolations(){
        return sqlService.executeSql2(SqlStatement.OpenLicenseViolations);
    }
    
    public List<DbRow> findDiscoveredLicenseViolations(){
        return sqlService.executeSql2(SqlStatement.DiscoveredLicenseViolations);
    }
    
    public List<DbRow> findFixedLicenseViolations(){
        return sqlService.executeSql2(SqlStatement.FixedLicenseViolations);
    }
    
    public List<DbRow> findWaivedLicenseViolations(){
        return sqlService.executeSql2(SqlStatement.WaivedLicenseViolations);
    }

    public List<Mttr> findMTTR(){

        return sqlService.executeSqlMttr(SqlStatement.MTTR2);


    }

    private boolean hasValue(Mttr m){
        boolean v = false;

        if (m.getPointA() > 0 || m.getPointB() > 0 || m.getPointC() > 0){
            v = true;
        }

        return v;
    }

}
