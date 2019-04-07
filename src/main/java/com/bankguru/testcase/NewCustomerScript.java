package com.bankguru.testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustormer;
import com.bankguru.actions.RegisterPage;

import CommonPage.Commontestcase;

public class NewCustomerScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustormer newCustormer;
	String email;

	static String emailLogin, passwordLogin;
	static String customerId;
	String customerNamevalid, numberName, specialCharacterName, nameCannotEmptyMsg, 
	dateOfBirthvalid,
			cannotBeNumbericMsg, cannotSpecialCharacterMsg, firstCharacterBlankSpaceMsg, 
			addressCannotEmptyMsg,addressvalid, namemustBeNumbericMsg, mustBeNumbericMsg,
			cityvalid, cityCannotEmptyMsg, citynumber,cityspecialCharacter, 
			statevalid, stateCannotEmptyMsg, statenumber, statespecialCharacter, 
			pinvalid,pinnumbernotenough, pinMustHave6DigitsMsg, pinCannotEmptyMsg, pinspecialCharacter, pinCharacter,
			mobileNumbervalid, mobileNumberCannotEmptyMsg,mobileBlankSpace,mobilespecialCharacter,
			emailCannotEmptyMsg,emailnotcom,emailvarchar,emailbeforea,emailnotdoccom,emailBlankSpace,
			passWordvalid, messegerRegisteredSuccessfully;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
// message chung

		cannotSpecialCharacterMsg = "Special characters are not allowed";
		firstCharacterBlankSpaceMsg = "First character can not have space";
		mustBeNumbericMsg = "Characters are not allowed";
// namecustomer
		numberName = "1234";
		specialCharacterName = "name!@#";
		customerNamevalid = "hoangxuan";
		nameCannotEmptyMsg = "Customer name must not be blank";
		cannotBeNumbericMsg = "Numbers are not allowed";
		namemustBeNumbericMsg = "Numbers are not allowed";

// Adress
		addressCannotEmptyMsg = "Address Field must not be blank";
		addressvalid = "Tân Hiệp Hóc Môn";
// date of birth
		dateOfBirthvalid = "12/10/1994";
// city
		cityvalid = "Ho Chi Minh";
		cityCannotEmptyMsg = "City Field must not be blank";
		citynumber = "1234";
		cityspecialCharacter = "city!@#";
//PIN
		pinMustHave6DigitsMsg = "PIN Code must have 6 Digits";
		pinvalid = "261094";
		pinnumbernotenough = "1234";
		pinCharacter = "1234PIN";
		pinCannotEmptyMsg = "PIN Code must not be blank";
		pinspecialCharacter = "@#";
		
		
//STATE		
		statevalid = "Ho Chi Minh";
		stateCannotEmptyMsg = "State must not be blank";
		statenumber = "1234";
		statespecialCharacter = "State!@#";
//MOBILE
		mobileNumberCannotEmptyMsg = "Mobile no must not be blank";
		mobileNumbervalid = "098686868";
		mobileBlankSpace = "09 89";
		mobilespecialCharacter = "0986!@#";
//EMAIL
		emailCannotEmptyMsg = "Email-ID must not be blank";
		emailnotdoccom = "guru99@gmail";
		emailvarchar = "guru99";
		emailbeforea = "Guru99@";
		emailnotcom="guru99@gmail.";
		emailBlankSpace= "guru99gmail. com";
		
		passWordvalid = "12345678";
		messegerRegisteredSuccessfully = "Customer Registered Successfully!!!";

		email = "hoangxuan" + randomEmail() + "@gmail.com";
		// loginPage = new LoginPage(driver);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.iputUsename(RegisterScript.emailLogin);
		loginPage.iputPassword(RegisterScript.passwordLogin);
		homePage = loginPage.clickLogin();
		verifyEqual(homePage.getWelcomString(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@BeforeMethod
	public void beforeMethod() {
		newCustormer = homePage.clickMenuNewCustomer();
	}

	@Test
	public void TC_01() {
		newCustormer.pressKeyTabCustomerName(Keys.TAB);
		verifyEqual(newCustormer.getDynamicText(nameCannotEmptyMsg), nameCannotEmptyMsg);

	}

	// @Test
	public void TC_02() {
		newCustormer.inputNumberCustomerName(numberName);
		verifyEqual(newCustormer.getDynamicText(cannotBeNumbericMsg), cannotBeNumbericMsg);

	}

	@Test
	public void TC_03() {
		newCustormer.inputNumberCustomerName(specialCharacterName);
		verifyEqual(newCustormer.getDynamicText(cannotSpecialCharacterMsg), cannotSpecialCharacterMsg);

	}

	@Test
	public void TC_04() {
		newCustormer.pressKeyTabCustomerName(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(firstCharacterBlankSpaceMsg), firstCharacterBlankSpaceMsg);

	}

	@Test
	public void TC_05() {
		newCustormer.pressKeyTabAddress(Keys.TAB);
		verifyEqual(newCustormer.getDynamicText(addressCannotEmptyMsg), addressCannotEmptyMsg);
	}

	@Test
	public void TC_06() {
		newCustormer.pressKeyTabAddress(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(firstCharacterBlankSpaceMsg), firstCharacterBlankSpaceMsg);
	}

//	1) Do not enter a value in CITY Field 2) Press TAB and move to next Field
	@Test
	public void TC_08() {
		newCustormer.pressKeyTabCity(Keys.TAB);
		verifyEqual(newCustormer.getDynamicText(cityCannotEmptyMsg), cityCannotEmptyMsg);
	}

//	9) Enter numeric value in CITY Field 1234 city123
	@Test
	public void TC_09() {
		newCustormer.inputNumberCity(citynumber);
		verifyEqual(newCustormer.getDynamicText(cannotBeNumbericMsg), cannotBeNumbericMsg);
	}

//	10) Enter Special Character In CITY Field : City!@#
	@Test
	public void TC_10() {
		newCustormer.inputNumberCity(cityspecialCharacter);
		verifyEqual(newCustormer.getDynamicText(cannotSpecialCharacterMsg), cannotSpecialCharacterMsg);
	}

//	11) Enter First character Blank space
	@Test
	public void TC_11() {
		newCustormer.pressKeyTabCity(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(firstCharacterBlankSpaceMsg), firstCharacterBlankSpaceMsg);
	}

//12 Verify State Field State cannot be empt1) Do not enter a value in STATE Field 2) Press TAB and move to next Field.An error message "State must not be blank" must be shown

	@Test
	public void TC_12() {
		newCustormer.pressKeyState(Keys.TAB);
		verifyEqual(newCustormer.getDynamicText(stateCannotEmptyMsg), stateCannotEmptyMsg);
	}

//13	 State cannot be numeric 1) Enter numeric value in STATE Field  1234 State123	An error message "Numbers are not allowed" must be shown
	// @Test
	public void TC_13() {
		newCustormer.inputNumberState(statenumber);
		verifyEqual(newCustormer.getDynamicText(cannotBeNumbericMsg), cannotBeNumbericMsg);
	}

//	14 State cannot have special character 1) Enter Special Character In STATE Field [State!@# !@#]//	An error message "Special characters are not allowed" must be shown
	// @Test
	public void TC_14() {
		newCustormer.inputNumberState(statespecialCharacter);
		verifyEqual(newCustormer.getDynamicText(cannotSpecialCharacterMsg), cannotSpecialCharacterMsg);
	}

//	 15 State cannot have first blank space 1) Enter First character Blank space

	// @Test
	public void TC_15() {
		newCustormer.pressKeyState(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(firstCharacterBlankSpaceMsg), firstCharacterBlankSpaceMsg);
	}

//16.1	 Verify PIN Field PIN must be numeric 1) Enter character value in PIN  Field//	1234 An error message "PIN Code must have 6 Digits " must be shown
	// @Test
	public void TC_16_1() {
		newCustormer.inputNumberPin(pinnumbernotenough);
		verifyEqual(newCustormer.getDynamicText(pinMustHave6DigitsMsg), pinMustHave6DigitsMsg);
	}

//	16.2  input 1234PIN An error message "Characters are not allowed" must be shown

	// @Test
	public void TC_16_2() {
		newCustormer.inputNumberPin(pinCharacter);
		verifyEqual(newCustormer.getDynamicText(mustBeNumbericMsg), mustBeNumbericMsg);
	}

//	17 PIN cannot be empty//	1) Do not enter a value in PIN Field 2) Press TAB and move to next Field//	An error message "PIN code must not be blank" must be shown
	// @Test
	public void TC_17() {
		newCustormer.pressKeyPin(Keys.TAB);
		verifyEqual(newCustormer.getDynamicText(pinCannotEmptyMsg), pinCannotEmptyMsg);
	}

//	19 PIN cannot have special character 1) Enter Special Character In PIN Field !@# 123!@# An error message "Special characters are not allowed" must be shown
	// @Test
	public void TC_19() {
		newCustormer.inputNumberPin(pinspecialCharacter);
		verifyEqual(newCustormer.getDynamicText(cannotSpecialCharacterMsg), cannotSpecialCharacterMsg);
	}

	// 20. PIN cannot have first blank space 1) Enter First character Blank space An
	// error message "First character cannot be space" must be shown
	// @Test
	public void TC_20() {
		newCustormer.pressKeyPin(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(firstCharacterBlankSpaceMsg), firstCharacterBlankSpaceMsg);
	}

//	21 PIN cannot have blank space 1) Enter First character Blank space
//	An error message "PIN cannot have space" must be shown same 20
//22	 Verify Telephone Field Telephone cannot be empty 1) Do not enter a value in Telephone Field 2) Press TAB and move to next Field//	 An error message "Mobile no must not be blank" must be shown
	// @Test
	public void TC_21() {
		newCustormer.pressKeyMobileNumber(Keys.TAB);
		verifyEqual(newCustormer.getDynamicText(mobileNumberCannotEmptyMsg),mobileNumberCannotEmptyMsg);
	}

//23	Telephone cannot have first character as blank space 1) Enter First character Blank space
//	An error message "First character cannot be space" must be shown
	// @Test
	public void TC_22() {
		newCustormer.pressKeyMobileNumber(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(firstCharacterBlankSpaceMsg), firstCharacterBlankSpaceMsg);
	}

//	24 Telephone cannot have spaces 1) Enter Blank space in Telephone 123 123
//	An error message "Telephone cannot have be space" must be shown
	// @Test
	public void TC_24() {
		newCustormer.inputNumberMobileNumber(mobileBlankSpace);
		verifyEqual(newCustormer.getDynamicText(mustBeNumbericMsg), mustBeNumbericMsg);
	}

//25	Telephone cannot have special character 1) Enter Special Character In Telephone Field
//	886636!@12 !@88662682 88663682!@
//	An error message "Special characters are not allowed" must be shown
	// @Test
	public void TC_25() {
		newCustormer.inputNumberMobileNumber(mobilespecialCharacter);
		verifyEqual(newCustormer.getDynamicText(cannotSpecialCharacterMsg),cannotSpecialCharacterMsg);
	}

//26	Verify Email Field Email cannot be empty
//	1) Do not enter a value in Email Field 2) Press TAB and move to next Field
//	An error message "Email ID must not be blank" must be shown
	// @Test
	public void TC_26() {
		newCustormer.pressKeyEmail(Keys.TAB);
		verifyEqual(newCustormer.getDynamicText(emailCannotEmptyMsg), emailCannotEmptyMsg);
	}

//	27 Email must be in correct format Enter invalid email in Email field
//	 guru99@gmail guru99 Guru99@ guru99@gmail. guru99gmail. com
//	 An error message "Email-ID is not valid"" must be shown
	// @Test
	public void TC_27_1() {
		newCustormer.inputNumberEmail(emailnotdoccom);
		verifyEqual(newCustormer.getDynamicText(emailCannotEmptyMsg), emailCannotEmptyMsg);
	}

	// @Test
	public void TC_27_2() {
		newCustormer.inputNumberEmail(emailvarchar);
		verifyEqual(newCustormer.getDynamicText(emailCannotEmptyMsg), emailCannotEmptyMsg);
	}

	// @Test
	public void TC_27_3() {
		newCustormer.inputNumberEmail(emailbeforea);
		verifyEqual(newCustormer.getDynamicText(emailCannotEmptyMsg), emailCannotEmptyMsg);
	}

	// @Test
	public void TC_27_4() {
		newCustormer.inputNumberEmail(emailnotcom);
		verifyEqual(newCustormer.getDynamicText(emailCannotEmptyMsg), emailCannotEmptyMsg);
	}

	// @Test
	public void TC_27_5() {
		newCustormer.inputNumberEmail(emailBlankSpace);
		verifyEqual(newCustormer.getDynamicText(emailCannotEmptyMsg), emailCannotEmptyMsg);
	}

//	29 Email cannot have space 1) Enter Blank space in Email //	An error message "Email-ID is not valid" must be shown
	@Test
	public void TC_29() {
		newCustormer.pressKeyEmail(Keys.SPACE);
		verifyEqual(newCustormer.getDynamicText(firstCharacterBlankSpaceMsg), firstCharacterBlankSpaceMsg);
	}

//	30.Verify Field LabelsCheck all Fields name(Label) are as documented in SRS for all modules Cross check Field names with that in SRS Field names in SRS and system should match
	@Test
	public void TC_30() {
		newCustormer.inputNumberCustomerName(customerNamevalid);
		newCustormer.inputDateOfBirth(dateOfBirthvalid);
		newCustormer.inputAddress(addressvalid);
		newCustormer.inputNumberCity(cityvalid);
		newCustormer.inputNumberState(statevalid);
		newCustormer.inputNumberPin(pinvalid);
		newCustormer.inputNumberMobileNumber(mobileNumbervalid);
		newCustormer.inputNumberEmail(email);
		newCustormer.inputPassWord(passWordvalid);
		newCustormer.clickSummit();
		verifyEqual(newCustormer.getDynamicText(messegerRegisteredSuccessfully), messegerRegisteredSuccessfully);
		customerId = newCustormer.getTexCustomerId();
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
