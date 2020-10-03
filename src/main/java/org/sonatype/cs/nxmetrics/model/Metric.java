package org.sonatype.cs.nxmetrics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;

@Entity
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @CsvBindByName
	private String applicationId;
	@CsvBindByName
	private String applicationPublicId;
	@CsvBindByName
	private String applicationName;
	@CsvBindByName
	private String organizationName;

	@CsvBindByName
	private String timePeriodStart;
	
	@CsvBindByName
	private int evaluationCount;
	
	@CsvBindByName
	// @Column(name = "mttrModerateThreat", updatable = false, nullable = true)
	private Float mttrModerateThreat;
	
	@CsvBindByName
	// @Column(name = "mttrSevereThreat", updatable = false, nullable = true)
	private Float mttrSevereThreat;
	
	@CsvBindByName
	// @Column(name = "mttrCriticalThreat", updatable = false, nullable = true)
	private Float mttrCriticalThreat;

	@CsvBindByName
	private int discoveredCountSecurityModerate;
	@CsvBindByName
	private int discoveredCountSecuritySevere;
	@CsvBindByName
	private int discoveredCountSecurityCritical;
	@CsvBindByName
	private int discoveredCountLicenseModerate;
	@CsvBindByName
	private int discoveredCountLicenseSevere;
	@CsvBindByName
	private int discoveredCountLicenseCritical;

	@CsvBindByName
	private int fixedCountSecurityModerate;
	@CsvBindByName
	private int fixedCountSecuritySevere;
	@CsvBindByName
	private int fixedCountSecurityCritical;
	@CsvBindByName
	private int fixedCountLicenseModerate;
	@CsvBindByName
	private int fixedCountLicenseSevere;
	@CsvBindByName
	private int fixedCountLicenseCritical;

	@CsvBindByName
	private int waivedCountSecurityModerate;
	@CsvBindByName
	private int waivedCountSecuritySevere;
	@CsvBindByName
	private int waivedCountSecurityCritical;
	@CsvBindByName
	private int waivedCountLicenseModerate;	
	@CsvBindByName
	private int waivedCountLicenseSevere;
	@CsvBindByName
	private int waivedCountLicenseCritical;
	
	@CsvBindByName
	private int openCountAtTimePeriodEndSecurityModerate;
	@CsvBindByName
	private int openCountAtTimePeriodEndSecuritySevere;
	@CsvBindByName
	private int openCountAtTimePeriodEndSecurityCritical;
	@CsvBindByName
	private int openCountAtTimePeriodEndLicenseModerate;
	@CsvBindByName
	private int openCountAtTimePeriodEndLicenseSevere;
	@CsvBindByName
	private int openCountAtTimePeriodEndLicenseCritical;
    
}
