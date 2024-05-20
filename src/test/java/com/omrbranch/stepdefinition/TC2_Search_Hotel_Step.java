package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_Search_Hotel_Step extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User search hotel {string},{string},{string},{string},{string},{string} and {string}")
	public void searchWithAllFields(String state, String roomType, String checkIn, String checkOut, String noOfRoom,
			String noOfAdult, String noOfChildren) {
		pom.getSearchHotelPage().searchHotelWithAllFields(state, roomType, checkIn, checkOut, noOfRoom, noOfAdult,
				noOfChildren);

	}

	@Then("User should verify after search hotel success message {string}")
	public void VerificationSelectHotelMessage(String actualSelectMessage) {
		Assert.assertEquals("Verify the Select Hotel Message", actualSelectMessage,
				pom.getSelectHotelPage().expectedSelectMessage());
		System.out.println("Select Hotel Message verified successfully");
	}

	@When("User search hotel {string},{string},{string},{string},{string} and {string}")
	public void searchWithMandatoryFields(String state, String roomType, String checkIn, String checkOut,
			String noOfRoom, String noOfAdult) {
		pom.getSearchHotelPage().searchHotelWithMandatoryFields(state, checkIn, checkOut, noOfRoom, noOfAdult);
	}

	@When("User click search button")
	public void user_click_search_button() {
		pom.getSearchHotelPage().enterWithoutAnyDetails();
	}

	@Then("User should verify after search hotel error message {string},{string},{string},{string},{string} and {string}")
	public void enterWithoutAnyFieldsErrorMessage(String stateError, String cityError, String checkInError,
			String checkOutError, String noOfRoomsError, String noOfAdultsError) {

		Assert.assertEquals("Verify State Error message", stateError, pom.getSearchHotelPage().stateError());
		Assert.assertEquals("Verify city Error message", cityError, pom.getSearchHotelPage().cityError());
		Assert.assertEquals("Verify checkInError Error message", checkInError, pom.getSearchHotelPage().CheckInError());
		Assert.assertEquals("Verify checkOutError Error message", checkOutError,
				pom.getSearchHotelPage().checkOutError());
		Assert.assertEquals("Verify noOfRooms Error message", noOfRoomsError,
				pom.getSearchHotelPage().noOfRoomsError());
		Assert.assertEquals("Verify noOfAdults Error message", noOfAdultsError,
				pom.getSearchHotelPage().noOfAdultsError());
		System.out.println("All error messages are verified");
	}

	@Then("User should verify all hotel listed in the selected room type {string}")
	public void user_should_verify_all_hotel_listed_in_the_selected_room_type(String roomType) {
		pom.getSelectHotelPage().verifyRoomTypeInAllHotelName(roomType);
	}

	@Then("User should verify the header contains {string}")
	public void user_should_verify_the_header_contains(String roomType) {
		boolean verifythehotelNameWithRoomType = pom.getSelectHotelPage().verifythehotelNameWithRoomType(roomType);
		Assert.assertTrue("Verify the header contains the room typoe", verifythehotelNameWithRoomType);
	}

	@When("User select the option to sort hotels by price from Low to High")
	public void user_select_the_option_to_sort_hotels_by_price_from_low_to_high() throws InterruptedException {
		pom.getSelectHotelPage().clickLowToHigh();
	}

	@Then("User should verify the displayed hotels name are in Low to High")
	public void user_should_verify_the_displayed_hotels_name_are_in_low_to_high() {
		pom.getSelectHotelPage().verifyPriceLowToHigh();
		
		
	}

	@When("User select the option to sort hotels by price from High to Low")
	public void user_select_the_option_to_sort_hotels_by_price_from_high_to_low() throws InterruptedException {
		pom.getSelectHotelPage().clickHighToLow();
	}

	@Then("User should verify the displayed hotels name are in High to Low")
	public void user_should_verify_the_displayed_hotels_name_are_in_high_to_low() {
		pom.getSelectHotelPage().verifyPriceHighToLow();
	}

	@When("User select the option to sort hotels by name in Ascending order")
	public void user_select_the_option_to_sort_hotels_by_name_in_ascending_order() throws InterruptedException {
		pom.getSelectHotelPage().clickNameAscending();
	}

	@Then("User should verify the displayed hotels name are in Ascending order")
	public void user_should_verify_the_displayed_hotels_name_are_in_ascending_order() {
		pom.getSelectHotelPage().verifyAscendingOrder();
	}

	@When("User select the option to sort hotels by name in Descending order")
	public void user_select_the_option_to_sort_hotels_by_name_in_descending_order() throws InterruptedException {
		pom.getSelectHotelPage().clickNameDescending();
	}

	@Then("User should verify the displayed hotels name are in Descending order")
	public void user_should_verify_the_displayed_hotels_name_are_in_descending_order() {
		pom.getSelectHotelPage().verifyDescendingOrder();
	}

}
