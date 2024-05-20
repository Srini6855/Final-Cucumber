package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_Change_Booking_Step {
	PageObjectManager pom = new PageObjectManager();

	@When("User navigate to My Booking page")
	public void user_navigate_to_my_booking_page() {
		pom.getBookingConfirmationPage().toMyAccountPage();
	}

	@Then("User should verify after navigate to My Booking page success message as {string}")
	public void user_should_verify_after_navigate_to_my_booking_page_success_message_as(String actualBookingMessage) {
		boolean contains = pom.getMyBookingPage().expectedBookingMessage().contains(actualBookingMessage);
		Assert.assertTrue("Verify the booking success message", contains);
		System.out.println("Booking message verified Successfully");
	}

	@When("User search the Order ID")
	public void user_search_the_order_id() {
		pom.getMyBookingPage().searchOrderId();
	}

	@Then("User should verify same booked Order ID is present or not")
	public void user_should_verify_same_booked_order_id_is_present_or_not() {
		Assert.assertTrue("Verify the same order is presenet", pom.getMyBookingPage().getFirstOrderId());
	}

	@Then("User should verify same booked Hotel Name is present or not")
	public void user_should_verify_same_booked_hotel_name_is_present_or_not() {
		Assert.assertTrue("Verify the same booked hotel name is present or not",
				pom.getMyBookingPage().verifyTheSameBookedHotelNameIsPresent());
	}

	@Then("User should verify same booked Hotel Price is present or not")
	public void user_should_verify_same_booked_hotel_price_is_present_or_not() {
//		Assert.assertTrue("Verify the same booked hotel is present or not ", pom.getMyBookingPage().verifyTheSameHotelPriceIsPresent());
		System.out.println(pom.getMyBookingPage().hotelPriceInSelectPage());
		System.out.println(pom.getMyBookingPage().hotelPriceInMyBookingPage());
		Assert.assertTrue("Verify the same booked hotel price is present or not", pom.getMyBookingPage().verifySameBookedHotelPriceIsPresent());

	}

	@When("User edit the Check-in Date {string}")
	public void user_edit_the_check_in_date(String modifyDate) {
		pom.getMyBookingPage().modifyChechInDate(modifyDate);
	}

	@Then("User should verify after modify check-in date success message {string}")
	public void user_should_verify_after_modify_check_in_date_success_message(String actualMessage) {
		Assert.assertEquals("Verify the update successful message", actualMessage,
				pom.getMyBookingPage().expectedBookingSuccessMessage());
	}

	@When("User search the Order ID {string}")
	public void user_search_the_order_id(String string) {
		pom.getMyBookingPage().searchOrderId();
	}

	@When("User edit the Check-in Date for the first displayed Order ID {string}")
	public void user_edit_the_check_in_date_for_the_first_displayed_order_id(String chechInDate) {
		pom.getMyBookingPage().modifyChechInDate(chechInDate);
	}

}
