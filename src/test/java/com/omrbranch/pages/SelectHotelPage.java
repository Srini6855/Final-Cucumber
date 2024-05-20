package com.omrbranch.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public static String res;
	public static String price;
	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement textSelecHotel;
	@FindBy(xpath = "(//div[@class='col-md-5 hotel-suites'])[1]/h5")
	private WebElement textHotelName;
	@FindBy(xpath = "((//div[@class='prize'])/strong)[1]")
	private WebElement textPrize;
	@FindBy(xpath = "(//a[text()='Continue'])[1]")
	private WebElement btnContinue;
	@FindBy(xpath = "(//div[@class='col-md-5 hotel-suites'])/h5")
	private List<WebElement> textAllHotelName;
	@FindBy(xpath = "//label[@for='value_pltoh']")
	private WebElement radioBtnLowToHigh;
	@FindBy(xpath = "//label[@for='value_phtol']")
	private WebElement radioBtnHighToLow;
	@FindBy(xpath = "//label[@for='value_nasc']")
	private WebElement radioBtnNameAscending;
	@FindBy(xpath = "//label[@for='value_ndesc']")
	private WebElement radioBtnNameDescending;
	@FindBy(xpath = "//strong[@class='total-prize']")
	private List<WebElement> textAllHotelPrize;
	@FindBy(xpath = "//div[@class='row explore-hotels']//h2")
	private WebElement textBookings;
	@FindBy(xpath = "//a[text()='Standard/Deluxe/Suite/Luxury/Studio']")
	private WebElement textAllRoomType;

	public static String getRes() {
		return res;
	}

	public static String getPrice() {
		return price;
	}

	public WebElement getTextAllRoomType() {
		return textAllRoomType;
	}

	public WebElement getTextBookings() {
		return textBookings;
	}

	public List<WebElement> getTextAllHotelPrize() {
		return textAllHotelPrize;
	}

	public WebElement getRadioBtnLowToHigh() {
		return radioBtnLowToHigh;
	}

	public WebElement getRadioBtnHighToLow() {
		return radioBtnHighToLow;
	}

	public WebElement getRadioBtnNameAscending() {
		return radioBtnNameAscending;
	}

	public WebElement getRadioBtnNameDescending() {
		return radioBtnNameDescending;
	}

	public List<WebElement> getTextAllHotelName() {
		return textAllHotelName;
	}

	public WebElement getTextSelecHotel() {
		return textSelecHotel;
	}

	public WebElement getTextHotelName() {
		return textHotelName;
	}

	public WebElement getTextPrize() {
		return textPrize;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public String expectedSelectMessage() {
		String elementGetText = elementGetText(textSelecHotel);
		return elementGetText;

	}

	public boolean verifyRoomTypeInAllHotelName(String roomType) {
		boolean contains = true;
		for (int i = 0; i < textAllHotelName.size(); i++) {
			WebElement webElement = textAllHotelName.get(i);
			String text = webElement.getText();
			contains = text.contains(roomType);
		}
		if (contains) {
			System.out.println("All hotel listed in selected room type");
		} else {
			System.out.println("All hotel not listed in selected room type");
		}
		return contains;

	}

	public void clickLowToHigh() throws InterruptedException {
		elementClick(radioBtnLowToHigh);
		sleep();
	}

	public void clickHighToLow() throws InterruptedException {
		elementClick(radioBtnHighToLow);
		sleep();

	}

	public void clickNameAscending() throws InterruptedException {
		elementClick(radioBtnNameAscending);
		sleep();
	}

	public void clickNameDescending() throws InterruptedException {
		elementClick(radioBtnNameDescending);
		sleep();
	}

	public boolean verifyPriceLowToHigh() {
		List<Integer> dev = new ArrayList<>();
		for (int i = 0; i < textAllHotelPrize.size(); i++) {
			WebElement webElement = textAllHotelPrize.get(i);
			String text = webElement.getText();
			String substring = text.substring(2);
			String replace = substring.replace(",", "");
			int int1 = Integer.parseInt(replace);
			dev.add(int1);
		}
		List<Integer> qa = new ArrayList<>();
		qa.addAll(dev);
		Collections.sort(qa);
		boolean equals = qa.equals(dev);
		if (equals) {
			System.out.println("Low to High order is correct");
		} else {
			System.out.println("Low to High order is not correct");
		}
		return equals;
	}

	public boolean verifyPriceHighToLow() {

		List<Integer> dev = new ArrayList<>();
		for (int i = 0; i < textAllHotelPrize.size(); i++) {
			WebElement webElement = textAllHotelPrize.get(i);
			String text = webElement.getText();
			String substring = text.substring(2);
			String replace = substring.replace(",", "");
			int int1 = Integer.parseInt(replace);
			dev.add(int1);
		}
		List<Integer> qa = new ArrayList<>();
		qa.addAll(dev);
		Collections.sort(qa);
		Collections.reverse(qa);
		boolean equals = qa.equals(dev);
		if (equals) {
			System.out.println("High to Low order is correct");
		} else {
			System.out.println("High to Low order is not correct");
		}
		return equals;

	}

	public void verifyAscendingOrder() {
		List<String> dev = new ArrayList<>();
		for (WebElement name : textAllHotelName) {
			String text = name.getText();
			dev.add(text);
		}
		List<String> qa = new ArrayList<>();
		qa.addAll(dev);
		Collections.sort(qa);
		boolean equals = qa.equals(dev);
		if (equals) {
			System.out.println("Ascending order is correct");
		} else {
			System.out.println("Ascending order is not correct");
		}
	}

	public void verifyDescendingOrder() {
		List<String> dev = new ArrayList<>();
		for (WebElement name : textAllHotelName) {
			String text = name.getText();
			dev.add(text);
		}
		List<String> qa = new ArrayList<>();
		qa.addAll(dev);
		Collections.sort(qa);
		Collections.reverse(qa);
		System.out.println(qa);
		System.out.println(dev);
		boolean equals = qa.equals(dev);
		if (equals) {
			System.out.println("Descending order is correct");
		} else {
			System.out.println("Descending order is not correct");
		}
	}

	public String textFirstHotelName() {
		return elementGetText(textHotelName);
	}

	public String textFirstHotelPrice() {
		return elementGetText(textPrize);
	}

	public void clickContinue() {
		elementClick(btnContinue);
	}

	public void acceptAlert() {
		alertaccept();
	}

	public String textBookingss() {
		return elementGetText(textBookings);
	}

	public void dismissAlert() {
		alertDismiss();

	}

	public String hotelNameWithoutRoomTypes() {
		String string = elementGetText(textHotelName);
		String[] split = string.split(" ");
		res = "";
		res = res + split[0];
		return res;
	}

	public String hotelPrize() {
		price = elementGetText(textPrize);
		return price;
	}

	public boolean verifythehotelNameWithRoomType(String roomType) {

		String[] split = roomType.split("/");
		List<String> roomTypee = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			String room = split[i];
			roomTypee.add(room);
		}
		List<String> allHotelName = new ArrayList<>();
		for (int i = 0; i < textAllHotelName.size(); i++) {
			WebElement webElement = textAllHotelName.get(i);
			String text = webElement.getText();
			String[] name = text.split(" ");
			String nameWithoutHotel = name[name.length - 1];
			allHotelName.add(nameWithoutHotel);

		}
		List<String> onlyHotelName = new ArrayList<>();
		onlyHotelName.addAll(allHotelName);
		Set<String> roomtypee = new LinkedHashSet<>();
		roomtypee.addAll(onlyHotelName);
		allHotelName.clear();
		allHotelName.addAll(roomtypee);
		Collections.sort(roomTypee);
		Collections.sort(allHotelName);
		System.out.println(roomTypee);
		System.out.println(allHotelName);
		return roomTypee.equals(allHotelName);

	}
}
