package org.sonatype.cs.nxmetrics.runner;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.cs.nxmetrics.service.FilenameService;
import org.sonatype.cs.nxmetrics.service.SqlService;
import org.sonatype.cs.nxmetrics.util.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value=1)
@Component
public class LoadSuccessMetricsRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LoadSuccessMetricsRunner.class);

    @Autowired
    private SqlService sqlService;

    @Autowired
    private FilenameService filenameService;

    @Override
	public void run(String... args) throws Exception {

		log.info("In: LoadSuccessMetricsFileRunner");
		
		String csvFileName = filenameService.getFilename("successmetrics");
        String header = "applicationId,applicationName,applicationPublicId,";

        log.info("Reading csv file: " + csvFileName);

        File f = new File(csvFileName.toString());

        if (f.exists() && !f.isDirectory() && f.length() > 0) {

            String firstLine = filenameService.getFirstLine(csvFileName);

            if (!firstLine.startsWith(header)) {
                log.error(firstLine);
            } 
            else {

                String stmt = SqlStatement.MetricsTable + "('" + csvFileName + "')";	

                sqlService.ExecuteSql(stmt);

                FilenameService.successMetricsReportExists = true;

				log.info("Success Metrics loaded.");
			}
		}
		else {
			log.info("No Success Metrics data");
		}
	}
}
