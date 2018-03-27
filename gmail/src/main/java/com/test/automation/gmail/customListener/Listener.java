package com.test.automation.gmail.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.gmail.TestBase.TestBase;

public class Listener extends TestBase implements ITestListener {

	public static final Logger Log = Logger.getLogger(Listener.class.getName());
	
	public void onTestStart(ITestResult result) {
		
		String methodname = result.getName();
		Log.info("-----------------The Start of Testcase: "+methodname);
		
		}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getName();
		Log.info("-----------------The Testcase is success: "+methodname);
		
		File srcFile;
		
		srcFile = getScreenShot();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/gmail/";
		File destFile = new File((String)reportDirectory + "/passed_screenshots/" + methodname + "_" + formater.format(calendar) + ".png");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getName();
		Log.info("The Test case is failed: "+methodName);
		File scrFile;
		
		scrFile = getScreenShot();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/gmail/";
		File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
		
		
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Test is started "+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		//Reporter.log("Test is finished "+context.getName());
		
	}

}
