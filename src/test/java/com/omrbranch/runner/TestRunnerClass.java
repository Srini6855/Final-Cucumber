package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"json:target/omrhotelbooking.json" }, dryRun = false, glue = "com.omrbranch.stepdefinition", features = "src\\test\\resources\\features")
public class TestRunnerClass {
	@AfterClass
	public static void reportGenerate() {
		Reporting.generateReports(
				"C:\\Users\\SRINIVASU\\eclipse-workspace\\FianlCucumber\\target\\omrhotelbooking.json");
	}
}
