package com.tca.beans;

public class ReportManager {

	private ReportGenerator reportGenerator;

	public ReportGenerator getReportGenerator() {
		return reportGenerator;
	}

	public void setReportGenerator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}
	
	public void generateReport() {
		reportGenerator.generateReport();
	}
	
}
