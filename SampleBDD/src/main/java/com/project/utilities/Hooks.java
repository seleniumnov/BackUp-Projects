package com.project.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base {

	public static int index = 0;
	String reportPath = "./TestData/StatusReport.html";
	
	public static List<String> scid = new ArrayList<String>();
	public static List<String> scname = new ArrayList<String>();
	public static List<String> scstatus = new ArrayList<String>();
	public static List<String> featureName = new ArrayList<String>();
	
	//public static int tagsCount = TestDemo.getCountOfTags();

	public static BufferedWriter bw1;

	@Before(order = 0)
	public void removeReportFile() {

		try {
			File dir = new File("./TestData/");
			for (File file : dir.listFiles()) {
				if (!file.isDirectory()) {
					file.delete();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	@Before(order = 1)
	public void setup1() {

		//String path = "C:\\Users\\suresh.kurry\\Downloads\\chromedriver_win32\\chromedriver.exe";
		index++;
		WebDriverManager.chromedriver().setup();
		/*
		 * ChromeDriverService service = new ChromeDriverService.Builder()
		 * .usingDriverExecutable(new File(path)) .usingAnyFreePort()
		 * //.usingPort(gen()) //.withEnvironment(ImmutableMap.of("DISPLAY", ":15"))
		 * .withSilent(false) .build();
		 * 
		 * 
		 * try { service.start(); } catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */		
		//ChromeOptions option = new ChromeOptions();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After(order = 1)
	public static void afterScenario(Scenario scenario) throws Exception {
		
		
		driver.get("https://fastag.hdfcbank.com/RetailRoadUserLogin/");
		
		driver.findElement(By.id("txtUserId")).sendKeys("12345");

		scname.add(scenario.getName());
		scstatus.add(scenario.getStatus().toUpperCase());

		System.out.println(scenario.getSourceTagNames());

		String[] feature = scenario.getId().split(";");
		featureName.add(feature[0]);
		scenario.write(scenario.getName() + " is Completed Execution");

	}

	@After(order = 0)
	public void AfterSteps(Scenario scenario) throws Exception {
		System.out.println("Close Webdriver instance");
		driver.close();
		//Base.getInstance().removeDriver();

		if (index == 3) {

			File file = new File(reportPath);

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter write = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(write);

			bw.write("<html>" + "\n");
			bw.write("<head><title>" + "Test Execution Report" + "</title>" + "\n");
			bw.write("</head>" + "\n");
			bw.write("<body>");
			bw.write("<font face='Tahoma' size='2'>" + "\n");
			bw.write("<u><h1 align='center'>"
					+ scenario.getSourceTagNames().toString().replace("[", "").replace("]", "").replace("@", "").trim()
					 +" Report" + "</h1></u>");
			bw.flush();
			bw.close();

			bw1 = new BufferedWriter(new FileWriter(file, true));

			bw1.write("<table align='center' border='0' width='70%' height='10'>");
			bw1.write("<tr><td width='70%' </td></tr>");
			bw1.write("<table align='center' border='1' width='70%' height='47'>");
			bw1.write("<tr>");

			bw1.write("</tr>");
			bw1.write("</tr>");

			bw1.write(
					"<td bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>S.No</font></b></td>");

			/*
			 * bw1.write(
			 * "<td bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma' size='2'>Class Name</font></b></td>"
			 * );
			 */

			bw1.write(
					"<td bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma' size='2'>Scenario Name</font></b></td>");
			bw1.write(
					"<td bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma' size='2'>Status</font></b></td>");
			bw1.write("</tr>");

			bw1.write("<tr>" + "\n");
			
			
			for (int i = 0; i < 3; i++) {

				updateResult(featureName.get(i), i, scname.get(i), scstatus.get(i));
			}

			bw1.write("</body>" + "\n");
			bw1.write("</html>");
			bw1.flush();
			bw1.close();
		}
	}

	private void updateResult(String featureName, int index, String scenarioName, String response) {

		try {

			String color = null;

			if (response.equalsIgnoreCase("PASSED")) {

				color = "#006400";
			} else {

				color = "#FF0000";
			}

			index = index + 1;

			bw1.write("<td bgcolor='#FFFFFF' align='Center'><b><font color='#000000' face='Tahoma' size='2'>" + index
					+ "</font></b></td>");

			/*
			 * bw1.write(
			 * "<td bgcolor='#FFFFFF' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
			 * + featureName + "</font></b></td>");
			 */

			bw1.write(
					"<td bgcolor='#FFFFFF' valign='middle' align='left'><b><font color='#000000' face='Tahoma' size='2'>"
							+ scenarioName + "</font></b></td>");
			bw1.write("<td bgcolor='#FFFFFF' valign='middle' align='left'><b><font color='" + color
					+ "' face='Tahoma' size='2'>" + response + "</font></b></td>");
			bw1.write("</tr>" + "\n");

		} catch (

		Exception e) {

			e.printStackTrace();
		}

	}

}
