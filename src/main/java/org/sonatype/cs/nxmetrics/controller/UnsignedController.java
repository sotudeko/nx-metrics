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
public class UnsignedController {
    private static final Logger log = LoggerFactory.getLogger(UnsignedController.class);

    @Autowired
    private DataService dataService;

    @GetMapping({ "/unsigned" })
    public String applications(Model model) {

        log.info("In UnsignedController");

        List<DbRow> applicationsOnboarded = dataService.runSql(SqlStatement.ApplicationsOnboarded);
        List<DbRow> numberOfScans = dataService.runSql(SqlStatement.NumberOfScans);
        List<DbRow> numberOfApplicationsScanned = dataService.runSql(SqlStatement.NumberOfApplicationsScanned);
        List<Mttr> mttr = dataService.runSqlMttr(SqlStatement.MTTR);

		model.addAttribute("applicationsOnboarded", applicationsOnboarded);
		model.addAttribute("numberOfScans", numberOfScans);
		model.addAttribute("numberOfApplicationsScanned", numberOfApplicationsScanned);
        model.addAttribute("mttr", mttr);
        
        return "reportUnsigned";
    }
}
