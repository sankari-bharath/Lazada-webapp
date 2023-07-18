package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter sparkReportor;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testcontext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		sparkReportor = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName ); //specify the location of extent report need to be saved
		
			try {
				sparkReportor.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			} catch (IOException e) {
							e.printStackTrace();
			}
	
			extent = new ExtentReports();

		extent.attachReporter(sparkReportor);
		extent.setSystemInfo("Host Name", "local Host");
		extent.setSystemInfo("Environment", "QA");

		sparkReportor.config().setDocumentTitle(" Emiratespost.ae QA test Report"); //title of the report
		sparkReportor.config().setReportName("Function Test Automation Report"); // Name of the report
		sparkReportor.config().setTheme(Theme.STANDARD); //theme

	}
	public void onTestSuccess(ITestResult tr)
	{

		logger=extent.createTest(tr.getName()); //Create a new entry in the report 
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); //send the pass info
	}
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); //Create a new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		logger.log(Status.WARNING,MarkupHelper.createLabel(tr.getName(),ExtentColor.BROWN));//send the Fail info

		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";

		File f=new File(screenshotpath)	;

		if(f.exists())
		{
			try {logger.fail("Screenhsot is below: "+ logger.addScreenCaptureFromPath(screenshotpath) );
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		
	}

	public void onTestSkipped(ITestResult tr)	
	{
		logger=extent.createTest(tr.getName());// create a new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));//sending skipped test

	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}

}




