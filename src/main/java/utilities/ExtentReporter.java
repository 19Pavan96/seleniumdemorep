package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentReport;
	public static ExtentReports getExtentReporter() {
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("TuterNinja Automation Result");
		reporter.config().setDocumentTitle("Test results");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating system","Windows 10");
		extentReport.setSystemInfo("testedBy", "Pavan");
		return extentReport;
		
	}

}
