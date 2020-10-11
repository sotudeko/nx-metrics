package org.sonatype.cs.nxmetrics.controller;

import org.sonatype.cs.nxmetrics.model.Metric;
import org.sonatype.cs.nxmetrics.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DataController {

    private static final Logger log = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataService dataService;

    @GetMapping({ "/data" })
    public String data(Model model) {

        log.info("In DataController");

        List<Metric> metrics = dataService.findAllMetrics();

        if (metrics.isEmpty()) {
        	log.info("DataController: No metrics data");
            model.addAttribute("message", "No metrics.");
            model.addAttribute("status", false);
        } 
        else {
        	log.info("DataController: got data... count=" + metrics.size());
			model.addAttribute("metrics", metrics);	
	        model.addAttribute("status", true);
        }
        
		return "data";
 		
    }
    
    
    
}
