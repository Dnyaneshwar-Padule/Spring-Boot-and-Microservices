package com.tca.beans;

public class PdfReportGenerator implements ReportGenerator {

	@Override
	public void generateReport(int pages) {
		System.out.println("PDF Report Generated with " + pages + " pages.");
	}

}
