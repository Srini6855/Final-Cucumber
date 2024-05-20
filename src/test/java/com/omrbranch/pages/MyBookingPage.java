package com.omrbranch.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

public class MyBookingPage extends BaseClass {
	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='col-md-5'])[1]")
	private WebElement textBookings;
	@FindBy(xpath = "(//div[@class='room-code']//span)[1]")
	private WebElement textBookingId;
	@FindBy(xpath = "(//div[@class='col-md-7 mobile-space-none']//h5)[1]")
	private WebElement textHotelName;
	@FindBy(xpath = "(//strong[@class='total-prize'])[1]")
	private WebElement textPrize;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement btnEdit;
	@FindBy(xpath = "//input[@name='check_in']")
	private WebElement txtCheckInDate;
	@FindBy(xpath = "//li[@class='alertMsg']")
	private WebElement textUpdateMessage;
	@FindBy(xpath = "//li[@class='alertMsg']")
	private WebElement textCancelMessage;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement txtSearch;
	@FindBy(xpath = "(//div[@class='room-code']//span)")
	private List<WebElement> textAllIds;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement btnConfirm;
	@FindBy(xpath = "//a[text()='Cancel']")
	private List<WebElement> btnCancel;

	public List<WebElement> getBtnCancel() {
		return btnCancel;
	}

	public WebElement getBtnConfirm() {
		return btnConfirm;
	}

	public List<WebElement> getTextAllIds() {
		return textAllIds;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getTextBookings() {
		return textBookings;
	}

	public WebElement getTextBookingId() {
		return textBookingId;
	}

	public WebElement getTextHotelName() {
		return textHotelName;
	}

	public WebElement getTextPrize() {
		return textPrize;
	}

	public WebElement getBtnEdit() {
		return btnEdit;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTextUpdateMessage() {
		return textUpdateMessage;
	}

	public WebElement getTextCancelMessage() {
		return textCancelMessage;
	}

	public String expectedBookingMessage() {
		return elementGetText(textBookings);
	}

	public void searchOrderId() {
		String string = elementGetText(textBookingId);
		elementSendKeysandEnter(txtSearch, string);

	}

	public String searchOrderId1() {
		String string = elementGetText(textBookingId);
		return string;

	}

	public boolean getFirstOrderId() {
		WebElement webElement = textAllIds.get(0);
		String text = webElement.getText();
		boolean equals = text.equals(searchOrderId1());
		return equals;

	}

	public void modifyChechInDate(String modifyDate) {
		elementClick(btnEdit);
		elementSendkeysJs(txtCheckInDate, modifyDate);
		elementClick(btnConfirm);
	}

	public String expectedBookingSuccessMessage() {
		return elementGetText(textUpdateMessage);
	}

	public void cancelBooking() {
		WebElement webElement = btnCancel.get(0);
		elementClick(webElement);
		alertaccept();
	}

	public String expectedCancelSuccessMessage() {
		return elementGetText(textCancelMessage);
	}

	public boolean verifyTheSameBookedHotelNameIsPresent() {
		String hotelNameInMyBookingPage = elementGetText(textHotelName);
		String hotelNameInSelecHotelPage = SelectHotelPage.res;
		return hotelNameInMyBookingPage.contains(hotelNameInSelecHotelPage);
	}

	public String hotelPriceInSelectPage() {
		String price = SelectHotelPage.price;
		return price.substring(2);
	}

	public String hotelPriceInMyBookingPage() {
		return elementGetText(textPrize);
	}
	
	public boolean verifySameBookedHotelPriceIsPresent() {
		return hotelPriceInMyBookingPage().contains(hotelPriceInSelectPage());
	}

}
