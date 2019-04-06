package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.EditCustomerUI;
import com.bankguru.ui.NewCustomerUI;

import CommonPage.commonFunction;

public class EditCustomer extends commonFunction {

	public EditCustomer(WebDriver driver) {
		super(driver);
	}

	public void pressKeyTabCustomerId(Keys key) {
		waitVisible(EditCustomerUI.CUSTOMER_ID_TXT);
		inputKeys(EditCustomerUI.CUSTOMER_ID_TXT, key);
	}

	public void inputCustomerId(String value) {
		waitVisible(EditCustomerUI.CUSTOMER_ID_TXT);
		input(EditCustomerUI.CUSTOMER_ID_TXT, value);
	}

	public String getTexCustomerId() {
		waitVisible(EditCustomerUI.CUSTOMER_ID_MSG);
		return getText(EditCustomerUI.CUSTOMER_ID_MSG);
	}

	public EditCustomer clickSummit() {
		waitVisible(EditCustomerUI.SUMMIT_BTN);
		click(EditCustomerUI.SUMMIT_BTN);
		return PageFactory.initElements(driver, EditCustomer.class);
	}

// lay Adress
	public void clearAddress() {
		waitVisible(EditCustomerUI.ADDRESS_TXT);
		clear(EditCustomerUI.ADDRESS_TXT);
	}

	public void pressKeyTabAddress(Keys key) {
		waitVisible(EditCustomerUI.ADDRESS_TXT);
		inputKeys(EditCustomerUI.ADDRESS_TXT, key);
	}

	public String getTexAddress() {
		waitVisible(EditCustomerUI.ADDRESS_MSG);
		return getText(EditCustomerUI.ADDRESS_MSG);
	}

	public void inputAddress(String value) {
		waitVisible(EditCustomerUI.ADDRESS_TXT);
		input(EditCustomerUI.ADDRESS_TXT, value);
	}

	/////////////////////////////////////////////////
// City
	public void pressKeyTabCity(Keys key) {
		waitVisible(EditCustomerUI.CITY_TXT);
		inputKeys(EditCustomerUI.CITY_TXT, key);
	}

	public String getTexCity() {
		waitVisible(EditCustomerUI.CITY_MSG);
		return getText(EditCustomerUI.CITY_MSG);
	}

	public void inputNumberCity(String value) {
		waitVisible(EditCustomerUI.CITY_TXT);
		input(EditCustomerUI.CITY_TXT, value);
	}

	public void clearCity() {
		waitVisible(EditCustomerUI.CITY_TXT);
		clear(EditCustomerUI.CITY_TXT);
	}

	// State
	public void pressKeyState(Keys key) {
		waitVisible(EditCustomerUI.STATE_TXT);
		inputKeys(EditCustomerUI.STATE_TXT, key);
	}

	public String getTexState() {
		waitVisible(EditCustomerUI.STATE_MSG);
		return getText(EditCustomerUI.STATE_MSG);
	}

	public void inputState(String value) {
		waitVisible(EditCustomerUI.STATE_TXT);
		input(EditCustomerUI.STATE_TXT, value);
	}

	public void clearState() {
		waitVisible(EditCustomerUI.STATE_TXT);
		clear(EditCustomerUI.STATE_TXT);
	}

	// Pin
	public void pressKeyPin(Keys key) {
		waitVisible(EditCustomerUI.PIN_TXT);
		inputKeys(EditCustomerUI.PIN_TXT, key);
	}

	public String getTexPin() {
		waitVisible(EditCustomerUI.PIN_MSG);
		return getText(EditCustomerUI.PIN_MSG);
	}

	public void inputNumberPin(String value) {
		waitVisible(EditCustomerUI.PIN_TXT);
		input(EditCustomerUI.PIN_TXT, value);
	}

	public void clearPin() {
		waitVisible(EditCustomerUI.PIN_TXT);
		clear(EditCustomerUI.PIN_TXT);
	}

	// Mobile
	public void pressKeyMobileNumber(Keys key) {
		waitVisible(EditCustomerUI.MOBLIE_NUMBER_TXT);
		inputKeys(EditCustomerUI.MOBLIE_NUMBER_TXT, key);
	}

	public String getTexMobileNumber() {
		waitVisible(EditCustomerUI.MOBLIE_NUMBER_MSG);
		return getText(EditCustomerUI.MOBLIE_NUMBER_MSG);
	}

	public void inputNumberMobileNumber(String value) {
		waitVisible(EditCustomerUI.MOBLIE_NUMBER_TXT);
		input(EditCustomerUI.MOBLIE_NUMBER_TXT, value);
	}

	public void clearMobileNumber() {
		waitVisible(EditCustomerUI.MOBLIE_NUMBER_TXT);
		clear(EditCustomerUI.MOBLIE_NUMBER_TXT);
	}

	// EMAIL
	public void pressKeyEmail(Keys key) {
		waitVisible(EditCustomerUI.EMAIL_TXT);
		inputKeys(EditCustomerUI.EMAIL_TXT, key);
	}

	public String getTexEmail() {
		waitVisible(EditCustomerUI.EMAIL_MSG);
		return getText(EditCustomerUI.EMAIL_MSG);
	}

	public void inputEmail(String value) {
		waitVisible(EditCustomerUI.EMAIL_TXT);
		input(EditCustomerUI.EMAIL_TXT, value);
	}

	public void clearEmail() {
		waitVisible(EditCustomerUI.EMAIL_TXT);
		clear(EditCustomerUI.EMAIL_TXT);
	}

//PASSWORD
	public void inputPassWord(String value) {
		waitVisible(EditCustomerUI.PASSWORD_TXT);
		input(EditCustomerUI.PASSWORD_TXT, value);
	}

}