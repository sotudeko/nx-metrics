package org.sonatype.cs.nxmetrics.util;

public class SqlStatement {

    public static String MetricsTable = "DROP TABLE IF EXISTS METRIC; " +
			"CREATE TABLE METRIC (" +
			" application_Id VARCHAR(250) DEFAULT NULL," +
			" application_Name VARCHAR(250) DEFAULT NULL," +
			" application_Public_Id VARCHAR(250) DEFAULT NULL," +
			" discovered_Count_License_Critical INT DEFAULT NULL," +
			" discovered_Count_License_Moderate INT DEFAULT NULL," +
			" discovered_Count_License_Severe INT DEFAULT NULL," +
			" discovered_Count_Security_Critical INT DEFAULT NULL," +
			" discovered_Count_Security_Moderate INT DEFAULT NULL," +
			" discovered_Count_Security_Severe INT DEFAULT NULL," +
			" evaluation_Count INT DEFAULT NULL," +
			" fixed_Count_License_Critical INT DEFAULT NULL," +
			" fixed_Count_License_Moderate INT DEFAULT NULL," +
			" fixed_Count_License_Severe INT DEFAULT NULL," +
			" fixed_Count_Security_Critical INT DEFAULT NULL," +
			" fixed_Count_Security_Moderate INT DEFAULT NULL," +
			" fixed_Count_Security_Severe INT DEFAULT NULL," +
			" mttr_Critical_Threat DOUBLE DEFAULT NULL," +
			" mttr_Moderate_Threat DOUBLE DEFAULT NULL," +
			" mttr_Severe_Threat DOUBLE DEFAULT NULL," +
			" open_Count_At_Time_Period_End_License_Critical INT DEFAULT NULL," +
			" open_Count_At_Time_Period_End_License_Moderate INT DEFAULT NULL," +
			" open_Count_At_Time_Period_End_License_Severe INT DEFAULT NULL," +
			" open_Count_At_Time_Period_End_Security_Critical INT DEFAULT NULL," +
			" open_Count_At_Time_Period_End_Security_Moderate INT DEFAULT NULL," +
			" open_Count_At_Time_Period_End_Security_Severe INT DEFAULT NULL," +
			" organization_Name VARCHAR(250) DEFAULT NULL," +
			" time_Period_Start VARCHAR(250) DEFAULT NULL," +
			" waived_Count_License_Critical INT DEFAULT NULL," +
			" waived_Count_License_Moderate INT DEFAULT NULL," +
			" waived_Count_License_Severe INT DEFAULT NULL," +
			" waived_Count_Security_Critical INT DEFAULT NULL," +
			" waived_Count_Security_Moderate INT DEFAULT NULL," +
			" waived_Count_Security_Severe INT DEFAULT NULL)" +
			"AS SELECT " +
			"applicationId," +
			"applicationName," +
			"applicationPublicId," +
			"discoveredCountLicenseCritical," +
			"discoveredCountLicenseModerate," +
			"discoveredCountLicenseSevere," +
			"discoveredCountSecurityCritical," +
			"discoveredCountSecurityModerate," +
			"discoveredCountSecuritySevere," +
			"evaluationCount," +
			"fixedCountLicenseCritical," +
			"fixedCountLicenseModerate," +
			"fixedCountLicenseSevere," +
			"fixedCountSecurityCritical," +
			"fixedCountSecurityModerate," +
			"fixedCountSecuritySevere," +
			"mttrCriticalThreat," +
			"mttrModerateThreat," +
			"mttrSevereThreat," +
			"openCountAtTimePeriodEndLicenseCritical," +
			"openCountAtTimePeriodEndLicenseModerate," +
			"openCountAtTimePeriodEndLicenseSevere," +
			"openCountAtTimePeriodEndSecurityCritical," +
			"openCountAtTimePeriodEndSecurityModerate," +
			"openCountAtTimePeriodEndSecuritySevere," +
			"organizationName," +
			"timePeriodStart," +
			"waivedCountLicenseCritical," +
			"waivedCountLicenseModerate," +
			"waivedCountLicenseSevere," +
			"waivedCountSecurityCritical," +
			"waivedCountSecurityModerate," +
			"waivedCountSecuritySevere " +
			" from csvread ";

    
}
