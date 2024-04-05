package com.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testframework.Keyword;

public class TakeScreenShotFailure implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		// can’t create object directly so typecast and then create
		TakesScreenshot ts = (TakesScreenshot) Keyword.driver;

		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".png"));
			System.out.println("*******Screenshot captured********");

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
