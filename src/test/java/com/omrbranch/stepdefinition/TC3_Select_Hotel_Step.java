package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_Select_Hotel_Step extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User should verify the first Hotel name {string} and Price")
	public void user_should_verify_the_first_hotel_name_and_price(String roomType) {
		boolean contains = pom.getSelectHotelPage().textFirstHotelName().contains(roomType);
		Assert.assertTrue("Verify the first hotel Name", contains);
		String hotelPrize = pom.getSelectHotelPage().hotelPrize();
		boolean price = hotelPrize.contains("$");
		Assert.assertTrue("Verify the first hotel price", price);

	}

	@Then("User should click the first hotel")
	public void user_should_click_the_first_hotel() {
		String hotelNameWithoutRoomTypes = pom.getSelectHotelPage().hotelNameWithoutRoomTypes();
		System.out.println(hotelNameWithoutRoomTypes);
		pom.getSelectHotelPage().clickContinue();
		
	}

	@Then("User should Accept alert")
	public void user_should_accept_alert() {
		pom.getSelectHotelPage().acceptAlert();

	}

	@Then("User should verify after select hotel success message {string}")
	public void user_should_verify_after_select_hotel_success_message(String bookings) {
		boolean contains = pom.getSelectHotelPage().textBookingss().contains(bookings);
		Assert.assertTrue("Verify the Booking message after select hotel", contains);
		System.out.println("Bookings message verified successfully");
	}

	@When("User should Dismiss alert")
	public void user_should_dismiss_alert() {
		pom.getSelectHotelPage().dismissAlert();
	}

	@Then("User should verify is in same page success message {string}")
	public void user_should_verify_is_in_same_page_success_message(String selectHotel) {
		boolean equals = pom.getSelectHotelPage().expectedSelectMessage().equals(selectHotel);
		Assert.assertTrue("Verify the page is in same success mesaage", equals);
		System.out.println("Browser is in same select page");
	}

}
