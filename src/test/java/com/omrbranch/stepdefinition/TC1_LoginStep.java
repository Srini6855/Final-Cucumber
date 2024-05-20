package com.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on OMR Branch page")
	public void user_is_on_omr_branch_page() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyValue("browser"));
		launchtheappln(getPropertyValue("url"));
		maximizewindow();
		implicitWait();
	}

	@When("User login {string} and {string}")
	public void user_login_and(String userName, String password) {
		pom.getLoginPage().login(userName, password);
	}

	@Then("User should verify after login success message as {string}")
	public void user_should_verify_after_login_success_message_as(String actualLoginMessage) {
		Assert.assertEquals("Verify success message after login", actualLoginMessage,
				pom.getSearchHotelPage().expectedWelcomeMessage());
		System.out.println("Login message Verified");
	}

	@When("User login {string} and {string} using Enter key")
	public void user_login_and_using_enter_key(String userName, String password) {
		pom.getLoginPage().loginEnter(userName, password);
	}

	@Then("User should verify after login error message as {string}")
	public void user_should_verify_after_login_error_message_as(String actualErrorMessage) {
		Assert.assertEquals("Verify error message after login", actualErrorMessage, pom.getLoginPage().expectedError());
		System.out.println("Error message verified");
	}

}
