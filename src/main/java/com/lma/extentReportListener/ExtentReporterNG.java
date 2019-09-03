package com.lma.extentReportListener;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		extent = new com.relevantcodes.extentreports.ExtentReports(outputDirectory + File.separator + "FlipkartExtentReportResult.html", true);
		
		for (ISuite iSuite : suites) {
			Map<String, ISuiteResult> result = iSuite.getResults();
			for (ISuiteResult iSuite2 : result.values()) {
				ITestContext context = iSuite2.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getFailedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		
	}

}
