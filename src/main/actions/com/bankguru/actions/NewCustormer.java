package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.NewCustomerUI;

import CommonPage.commonFunction;

public class NewCustormer extends commonFunction {

	public NewCustormer(WebDriver driver) {
		super(driver);
	}

	public void pressKeyTabCustomerName(Keys key) {
		waitVisible(NewCustomerUI.CUSTOMER_NAME_TXT);
		inputKeys(NewCustomerUI.CUSTOMER_NAME_TXT, key);
	}

	public void inputNumberCustomerName(String value) {
		waitVisible(NewCustomerUI.CUSTOMER_NAME_TXT);
		input(NewCustomerUI.CUSTOMER_NAME_TXT, value);
	}

	public String getDynamicText(String value) {
		waitVisibleDynamicElement(NewCustomerUI.DYNAMIC_MSG, value);
		return getTextDynamicElement(NewCustomerUI.DYNAMIC_MSG, value);
	}

	public void pressKeyTabAddress(Keys key) {
		waitVisible(NewCustomerUI.ADDRESS_TXT);
		inputKeys(NewCustomerUI.ADDRESS_TXT, key);
	}

	public void pressKeySpaceAddress(Keys key) {
		waitVisible(NewCustomerUI.ADDRESS_TXT);
		inputKeys(NewCustomerUI.ADDRESS_TXT, key);
	}

	public void inputAddress(String value) {
		waitVisible(NewCustomerUI.ADDRESS_TXT);
		input(NewCustomerUI.ADDRESS_TXT, value);
	}

	public void pressKeyTabCity(Keys key) {
		waitVisible(NewCustomerUI.CITY_TXT);
		inputKeys(NewCustomerUI.CITY_TXT, key);
	}

	public void inputNumberCity(String value) {
		waitVisible(NewCustomerUI.CITY_TXT);
		input(NewCustomerUI.CITY_TXT, value);
	}

	public void pressKeyState(Keys key) {
		waitVisible(NewCustomerUI.STATE_TXT);
		inputKeys(NewCustomerUI.STATE_TXT, key);
	}

	public void inputNumberState(String value) {
		waitVisible(NewCustomerUI.STATE_TXT);
		input(NewCustomerUI.STATE_TXT, value);
	}

	public void pressKeyPin(Keys key) {
		waitVisible(NewCustomerUI.PIN_TXT);
		inputKeys(NewCustomerUI.PIN_TXT, key);
	}

//	public String getTexPin() {
//		waitVisible(NewCustomerUI.PIN_MSG);
//		return getText(NewCustomerUI.PIN_MSG);
//	}

	public void inputNumberPin(String value) {
		waitVisible(NewCustomerUI.PIN_TXT);
		input(NewCustomerUI.PIN_TXT, value);
	}

	public void pressKeyMobileNumber(Keys key) {
		waitVisible(NewCustomerUI.MOBLIE_NUMBER_TXT);
		inputKeys(NewCustomerUI.MOBLIE_NUMBER_TXT, key);
	}

	public void inputNumberMobileNumber(String value) {
		waitVisible(NewCustomerUI.MOBLIE_NUMBER_TXT);
		input(NewCustomerUI.MOBLIE_NUMBER_TXT, value);
	}

	public void pressKeyEmail(Keys key) {
		waitVisible(NewCustomerUI.EMAIL_TXT);
		inputKeys(NewCustomerUI.EMAIL_TXT, key);
	}

	public void inputNumberEmail(String value) {
		waitVisible(NewCustomerUI.EMAIL_TXT);
		input(NewCustomerUI.EMAIL_TXT, value);
	}

	public void inputDateOfBirth(String value) {
		waitVisible(NewCustomerUI.DOB_DATEPICKER);
		input(NewCustomerUI.DOB_DATEPICKER, value);
	}

	public void inputPassWord(String value) {
		waitVisible(NewCustomerUI.PASSWORD_TXT);
		input(NewCustomerUI.PASSWORD_TXT, value);
	}

	public NewCustormer clickSummit() {
		waitVisible(NewCustomerUI.SUMMIT_BTN);
		click(NewCustomerUI.SUMMIT_BTN);
		return PageFactory.initElements(driver, NewCustormer.class);
	}

	public String getTexCustomerRegisteredSuccessfully() {
		waitVisible(NewCustomerUI.CUSTOMER_REGISTED_SUCCESSFUL);
		return getText(NewCustomerUI.CUSTOMER_REGISTED_SUCCESSFUL);
	}

	public String getTexCustomerId() {
		waitVisible(NewCustomerUI.CUSTOMER_ID);
		return getText(NewCustomerUI.CUSTOMER_ID);
	}

}