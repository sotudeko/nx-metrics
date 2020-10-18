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

        model.addAttribute("applicationsOnboardedAvg", sumAndAverageApplicationsOnboarded(applicationsOnboarded));
		model.addAttribute("numberOfScansAvg", sumAndAveragePointA(numberOfScans));
		model.addAttribute("numberOfApplicationsScannedAvg", sumAndAveragePointA(numberOfApplicationsScanned));

        DbRow discoveredSecurityViolationsTotals = dataService.runSql(SqlStatement.DiscoveredSecurityViolationsTotals).get(0);
        DbRow openSecurityViolationsTotals = dataService.runSql(SqlStatement.OpenSecurityViolationsTotals).get(0);
        DbRow fixedSecurityViolationsTotals = dataService.runSql(SqlStatement.FixedSecurityViolationsTotals).get(0);
        DbRow waivedSecurityViolationsTotals = dataService.runSql(SqlStatement.WaivedSecurityViolationsTotals).get(0);

        model.addAttribute("discoveredSecurityViolationsTotals", discoveredSecurityViolationsTotals);
        model.addAttribute("openSecurityViolationsTotals", openSecurityViolationsTotals);
        model.addAttribute("fixedSecurityViolationsTotals", fixedSecurityViolationsTotals);
        model.addAttribute("waivedSecurityViolationsTotals", waivedSecurityViolationsTotals);

        DbRow discoveredLicenseViolationsTotals = dataService.runSql(SqlStatement.DiscoveredLicenseViolationsTotals).get(0);
        DbRow openLicenseViolationsTotals = dataService.runSql(SqlStatement.OpenLicenseViolationsTotals).get(0);
        DbRow fixedLicenseViolationsTotals = dataService.runSql(SqlStatement.FixedLicenseViolationsTotals).get(0);
        DbRow waivedLicenseViolationsTotals = dataService.runSql(SqlStatement.WaivedLicenseViolationsTotals).get(0);

        model.addAttribute("discoveredLicenseViolationsTotals", discoveredLicenseViolationsTotals);
        model.addAttribute("openLicenseViolationsTotals", openLicenseViolationsTotals);
        model.addAttribute("fixedLicenseViolationsTotals", fixedLicenseViolationsTotals);
        model.addAttribute("waivedLicenseViolationsTotals", waivedLicenseViolationsTotals);

        int discoveredSecurityTotal = discoveredSecurityViolationsTotals.getPointA()+discoveredSecurityViolationsTotals.getPointB()+discoveredSecurityViolationsTotals.getPointC();
        int fixedSecurityTotal = fixedSecurityViolationsTotals.getPointA()+fixedSecurityViolationsTotals.getPointB()+fixedSecurityViolationsTotals.getPointC();
        int waivedSecurityTotal = waivedSecurityViolationsTotals.getPointA()+waivedSecurityViolationsTotals.getPointB()+waivedSecurityViolationsTotals.getPointC();

        int discoveredLicenseTotal = discoveredLicenseViolationsTotals.getPointA()+discoveredLicenseViolationsTotals.getPointB()+discoveredLicenseViolationsTotals.getPointC();
        int fixedLicenseTotal = fixedLicenseViolationsTotals.getPointA()+fixedLicenseViolationsTotals.getPointB()+fixedLicenseViolationsTotals.getPointC();
        int waivedLicenseTotal = waivedLicenseViolationsTotals.getPointA()+waivedLicenseViolationsTotals.getPointB()+waivedLicenseViolationsTotals.getPointC();

        int fixedWaived = fixedSecurityTotal+waivedSecurityTotal+fixedLicenseTotal+waivedLicenseTotal;
        int discovered = discoveredSecurityTotal+discoveredLicenseTotal;

        float fixRate = (((float)(fixedWaived)/discovered) * 100);

        model.addAttribute("fixRate", String.format("%.02f", fixRate));

        return "reportUnsigned";
    }

    private int[] sumAndAverageApplicationsOnboarded(List<DbRow> dataList) {
		
		int countLabels = dataList.size();
		int numberOfApplications = (int) dataList.get(dataList.size() - 1).getPointA();
        int dataAverage = numberOfApplications/countLabels;
        
        int total = numberOfApplications;
        int avg = dataAverage;

        int[] values = new int[]{total, avg};
		return values;
    }
    
    public int[] sumAndAveragePointA(List<DbRow> dataList) {
		
		int countLabels = 0;
		int sumData = 0;
		
		for (DbRow dp : dataList) {
			int count = (int) dp.getPointA();
			
			if (count > 0) {
				sumData += count;
				countLabels++;
			}
        }
        
        int total = sumData;
        int avg = sumData/countLabels;

        int[] values = new int[]{total, avg};
		return values;
	}
}
