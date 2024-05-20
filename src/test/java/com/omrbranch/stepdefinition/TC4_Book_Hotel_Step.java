package com.omrbranch.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_Book_Hotel_Step {

	PageObjectManager pom = new PageObjectManager();

	@When("User add Guest Details {string},{string},{string},{string} and {string}")
	public void user_add_guest_details_and(String salutation, String firstName, String lastName, String mobileNo,
			String email) {
		pom.getBookHotelPage().addGuestDetails(salutation, firstName, lastName, mobileNo, email);
	}

	@When("User add GST Details {string},{string} and {string}")
	public void user_add_gst_details_and(String registrationNo, String companyName, String companyAddress) {
		pom.getBookHotelPage().addGstDetails(registrationNo, companyName, companyAddress);
	}

	@Then("User add Special Request {string}")
	public void user_add_special_request(String specialRequest) {
		pom.getBookHotelPage().addSpecialRequest(specialRequest);
	}

	@When("User enter payment details, procced with Card Type {string}")
	public void user_enter_payment_details_procced_with_card_type(String card,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(0);
		String selectCard = map.get("Select Card");
		String cardNo = map.get("Card No");
		String cardName = map.get("Card Name");
		String month = map.get("Month");
		String year = map.get("Year");
		String cvv = map.get("CVV");
		pom.getBookHotelPage().addPaymentDetails(card, selectCard, cardNo, cardName, month, year, cvv);

	}

	@When("User should verify after hotel booking success message {string} and save the order ID")
	public void user_should_verify_after_hotel_booking_success_message_and_save_the_order_id(
			String actualBookingMessage) {
		Assert.assertEquals("Verify the booking success message ", actualBookingMessage,
				pom.getBookingConfirmationPage().expectedBookingMessage());
		String saveOrderId = pom.getBookingConfirmationPage().saveOrderId();
		System.out.println(saveOrderId);

	}

	@Then("User should verify same selected Hotel is booked or not")
	public void user_should_verify_same_selected_hotel_is_booked_or_not() {
		Assert.assertTrue("Verify the same seleceted name is booked ",
				pom.getBookingConfirmationPage().veriyTheSameHotelNameIsBooked());

	}

	@When("User without entering payment deatils and click Submit")
	public void user_without_entering_payment_deatils_and_click_submit() {
		pom.getBookHotelPage().clickSubmitWithoutAnyDetails();
	}

	@Then("User should verify after payment details error message {string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_payment_details_error_message_and(String cardTpeErro, String cardError,
			String numberError, String nameError, String dateError, String cvvError) {
		Assert.assertEquals("Verify the card type error message", cardTpeErro,
				pom.getBookHotelPage().getCardTypeError());
		Assert.assertEquals("Verify the card  error message", cardError, pom.getBookHotelPage().getCardError());
		Assert.assertEquals("Verify the card number error message", numberError,
				pom.getBookHotelPage().getCardNumberError());
		Assert.assertEquals("Verify the card name error message", nameError, pom.getBookHotelPage().getCardNameError());
		Assert.assertEquals("Verify the card date error message", dateError, pom.getBookHotelPage().getDateError());
		Assert.assertEquals("Verify the card cvv error message", cvvError, pom.getBookHotelPage().getCvvError());
	}

	@When("User click next untill payment page comes")
	public void user_click_next_untill_payment_page_comes() {
		pom.getBookHotelPage().clickNextTillPayment();
	}

	@Then("User Click next")
	public void user_click_next() {
		pom.getBookHotelPage().clickNextAfterGstNext();
	}

	@When("User Click next in special request page")
	public void user_click_next_in_special_request_page() {
		pom.getBookHotelPage().clickNextAfterSpecialRequest();
	}

}
