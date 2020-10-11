package org.sonatype.cs.nxmetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.cs.nxmetrics.model.DbRow;
import org.sonatype.cs.nxmetrics.service.DataService;

@Controller
public class ApplicationsController {
    private static final Logger log = LoggerFactory.getLogger(ApplicationsController.class);

    @Autowired
    private DataService dataService;

    @GetMapping({ "/applications" })
    public String applications(Model model) {

        log.info("In ApplicationsController");
        
        List<DbRow> data = dataService.findApplicationsOnboarded();

        for (DbRow v : data){
            System.out.println(v.toString());
        }

        return "applications";
    }
}
