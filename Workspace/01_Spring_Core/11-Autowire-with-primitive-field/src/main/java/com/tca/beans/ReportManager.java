package com.tca.beans;

public class ReportManager {

	private ReportGenerator reportGenerator;
	private int pages;
	
	public ReportGenerator getReportGenerator() {
		return reportGenerator;
	}
	public void setReportGenerator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public void createReport() {
		reportGenerator.generateReport(pages);
	}
		
}

