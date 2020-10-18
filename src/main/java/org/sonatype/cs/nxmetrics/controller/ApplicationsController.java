package org.sonatype.cs.nxmetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.cs.nxmetrics.model.DbRow;
import org.sonatype.cs.nxmetrics.model.Mttr;
import org.sonatype.cs.nxmetrics.service.DataService;
import org.sonatype.cs.nxmetrics.util.SqlStatement;

@Controller
public class ApplicationsController {

    private static final Logger log = LoggerFactory.getLogger(ApplicationsController.class);

    @Autowired
    private DataService dataService;

    @GetMapping({ "/applications" })
    public String applications(Model model) {

        log.info("In ApplicationsController");

        List<DbRow> applicationsOnboarded = dataService.runSql(SqlStatement.ApplicationsOnboarded);
        List<DbRow> numberOfScans = dataService.runSql(SqlStatement.NumberOfScans);
        List<DbRow> numberOfApplicationsScanned = dataService.runSql(SqlStatement.NumberOfApplicationsScanned);
        List<Mttr> mttr = dataService.runSqlMttr(SqlStatement.MTTR);

		model.addAttribute("applicationsOnboarded", applicationsOnboarded);
		model.addAttribute("numberOfScans", numberOfScans);
		model.addAttribute("numberOfApplicationsScanned", numberOfApplicationsScanned);
        model.addAttribute("mttr", mttr);

        // String applicationOpenViolations = SqlStatement.ApplicationsOpenViolations + " where time_period_start = '" + latestTimePeriod + "' group by application_name" + " order by 2 desc, 3 desc";
        // List<DbRow> d = dataService.runSql(applicationOpenViolations);

        // model.addAttribute("mostCriticalApplicationName", d.get(0).getLabel());
        // model.addAttribute("mostCriticalApplicationCount", d.get(0).getPointA());
        // model.addAttribute("leastCriticalApplicationName", d.get(d.size()-1).getLabel());
        // model.addAttribute("leastCriticalApplicationCount", d.get(d.size()-1).getPointA());

        return "reportApplications";
    }
}
