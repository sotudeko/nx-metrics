package org.sonatype.cs.nxmetrics.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FilenameService {

    @Value("${csvfile.successmetrics}")
    private String successMetricsFile;
    
    public static boolean successMetricsReportExists = false;

	public String getFilename(String metricType) {
		
		String fileName = null;
		
		switch (metricType) {
			case "successmetrics": fileName = successMetricsFile; break;
			default: break;
		}
		
		return fileName;
		
	}
	
	public String getFirstLine(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName)); 

	    String line = br.readLine(); 
	    br.close();
	    return line;
	}
    
}
