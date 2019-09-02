package com.Automation.Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.Automation.Reports.ReportsExtent;
import com.aventstack.extentreports.Status;

public class GenericMethods extends ReportsExtent {

	public int index = 0;

	//@AfterMethod
	public void verifyTestResult(ITestResult result) {

		index++;

		if (result.getStatus() == ITestResult.SUCCESS) {

			updateResult(result.getTestClass().getName(), index, result.getName().toString(), "PASS");

		} else if (result.getStatus() == ITestResult.FAILURE) {

			updateResult(result.getTestClass().getName(), index, result.getName().toString(), "FAILED");

		} else if (result.getStatus() == ITestResult.SKIP) {

			updateResult(result.getTestClass().getName(), index, result.getName().toString(), "SKIPPED");

		}

	}

	private void updateResult(String classname, int index, String methodname, String response) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss aa");
			String startDateTime = dateFormat.format(new Date()).toString();
			System.out.println(startDateTime);
			System.out.println("Start Time---- " + startDateTime);

			String reportPath = System.getProperty("user.dir") + "/TestData/StatusReport.html";

			File file = new File(reportPath);

			System.out.println(file.exists());

			String color = null;

			if (response.equalsIgnoreCase("PASS")) {

				color = "#006400";
			} else {

				color = "#FF0000";
			}

			if (!file.exists()) {

				FileWriter write = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw = new BufferedWriter(write);

				bw.write("<html>" + "\n");
				bw.write("<head><title>" + "Test Execution Report" + "</title>" + "\n");
				bw.write("</head>" + "\n");
				bw.write("<body>");
				bw.write("<font face='Tahoma' size='2'>" + "\n");
				bw.write("<u><h1 align='center'>" + "Report" + "</h1></u>");
				bw.flush();
				bw.close();
			}
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(file, true));

			if (index == 1) {

				bw1.write("<table align='center' border='0' width='70%' height='10'>");
				bw1.write("<tr><td width='70%' </td></tr>");
				bw1.write("<table align='center' border='1' width='70%' height='47'>");
				bw1.write("<tr>");
				bw1.write(
						"<td colspan='1' align='center'><b><font color='#000000' face='Tahoma' size='2'>&nbsp;&nbsp;&nbsp;</font>");
				bw1.write("<td colspan='2' align='left'><b><font color='#000000' face='Tahoma' size='2'>Start Time : "
						+ startDateTime + "</font></b><font color='#0000FF'>");
				bw1.write("</tr>");
				bw1.write("</tr>");
				bw1.write(
						"<td bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>S.No</font></b></td>");
				bw1.write(
						"<td bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma' size='2'>Class Name</font></b></td>");
				bw1.write(
						"<td bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma' size='2'>Test Name</font></b></td>");
				bw1.write(
						"<td bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Response</font></b></td>");
				bw1.write("</tr>");
			}

			bw1.write("<tr>" + "\n");
			bw1.write("<td bgcolor='#FFFFFF' align='Center'><b><font color='#000000' face='Tahoma' size='2'>" + index
					+ "</font></b></td>");
			bw1.write(
					"<td bgcolor='#FFFFFF' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
							+ classname + "</font></b></td>");
			bw1.write(
					"<td bgcolor='#FFFFFF' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
							+ methodname + "</font></b></td>");
			bw1.write("<td bgcolor='#FFFFFF' valign='middle' align='left'><b><font color='" + color
					+ "' face='Tahoma' size='2'>" + response + "</font></b></td>");
			bw1.write("</tr>" + "\n");
			bw1.write("</body>" + "\n");
			bw1.write("</html>");
			bw1.flush();
			bw1.close();

		} catch (

		Exception e) {

			e.printStackTrace();
		}

	}

	public void input(WebElement ele, String testData, String fieldName) {

		ele.clear();
		ele.sendKeys(testData);
		logger.log(Status.INFO, "User Entered " + testData + " in  " + fieldName);
	}

	public void click(WebElement ele) {

		ele.click();

	}

	public String getElementText(WebElement ele) {

		return ele.getText();

	}

	public void selectVisibleTest(WebElement ele, String testData) {

		new Select(ele).selectByVisibleText(testData);
	}

}
