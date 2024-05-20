package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	public static void generateReports(String json) {
		File file = new File("C:\\Users\\SRINIVASU\\eclipse-workspace\\FianlCucumber\\target");
		Configuration configuration = new Configuration(file, "Omr All Page");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS", "WIN 11");
		configuration.addClassifications("Name", "Srinivasu A");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(json);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
	}



}
