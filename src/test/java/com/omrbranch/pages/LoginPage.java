package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	private WebElement txtUserName;
	@FindBy(id = "pass")
	private WebElement txtPassword;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement btnLogin;
	@FindBy(xpath = "//b[contains(@style,'color')]")
	private WebElement textUserError;

	public WebElement getTextUserError() {
		return textUserError;
	}
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public void login(String userName,String password) {
		elementSendKeys(txtUserName,userName);
		elementSendKeys(txtPassword, password);
		elementClick(btnLogin);
	}
	public void loginEnter(String userName,String password) {
		elementSendKeys(txtUserName,userName);
		elementSendKeysandEnter(txtPassword, password);
	}
	public String expectedError() {
		String string = elementGetText(textUserError);
		return string;
	}

}
