package com.tca.beans;

public class ExcelReportGenerator implements ReportGenerator {

	@Override
	public void generateReport(int pages) {
		System.out.println("Excel Report generated with " + pages + " pages");
	}

}
