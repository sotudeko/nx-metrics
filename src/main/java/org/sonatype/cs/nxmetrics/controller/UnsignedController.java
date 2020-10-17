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

@Controller
public class UnsignedController {
    private static final Logger log = LoggerFactory.getLogger(UnsignedController.class);

    @Autowired
    private DataService dataService;

    @GetMapping({ "/unsigned" })
    public String applications(Model model) {

        log.info("In UnsignedController");

        List<DbRow> applicationsOnboarded = dataService.findApplicationsOnboarded();
        List<DbRow> numberOfScans = dataService.findNumberOfScans();
        List<DbRow> numberOfApplicationsScanned = dataService.findNumberOfApplicationsScanned();
        List<Mttr> mttr = dataService.findMTTR();

		model.addAttribute("applicationsOnboarded", applicationsOnboarded);
		model.addAttribute("numberOfScans", numberOfScans);
		model.addAttribute("numberOfApplicationsScanned", numberOfApplicationsScanned);
        model.addAttribute("mttr", mttr);
        
        for (Mttr m : mttr) {
            log.info(m.toString());
        }

        return "unsigned";
    }
}
