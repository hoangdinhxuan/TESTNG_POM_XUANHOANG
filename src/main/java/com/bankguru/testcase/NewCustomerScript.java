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
	String email, emailLogin, passwordLogin;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);

		email = "hoangxuan" + randomEmail() + "@gmail.com";
		// loginPage = new LoginPage(driver);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = loginPage.clickHereLink();
		registerPage.inputEmailRegister(email);
		registerPage.clickSumit();
		emailLogin = registerPage.getUsername();
		passwordLogin = registerPage.getPasswork();
		loginPage = registerPage.navigateToLoginPage("http://demo.guru99.com/V4/");
		loginPage.iputUsename(emailLogin);
		loginPage.iputPassword(passwordLogin);
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
		verifyEqual(newCustormer.getTexCustomorname(), "Customer name must not be blank");

	}

	@Test
	public void TC_02() {
		newCustormer.inputNumberCustomerName("1234");
		verifyEqual(newCustormer.getTexCustomorname(), "Numbers are not allowed");

	}

	@Test
	public void TC_03() {
		newCustormer.inputNumberCustomerName("name!@# ");
		verifyEqual(newCustormer.getTexCustomorname(), "Special characters are not allowed");

	}

	@Test
	public void TC_04() {
		newCustormer.pressKeyTabCustomerName(Keys.SPACE);
		verifyEqual(newCustormer.getTexCustomorname(), "First character can not have space");

	}

	@Test
	public void TC_05() {
		newCustormer.pressKeyTabAddress(Keys.TAB);
		verifyEqual(newCustormer.getTexAddress(), "Address Field must not be blank");
	}

	@Test
	public void TC_06() {
		newCustormer.pressKeyTabAddress(Keys.SPACE);
		verifyEqual(newCustormer.getTexAddress(), "First character can not have space");
	}

//	1) Do not enter a value in CITY Field 2) Press TAB and move to next Field
	@Test
	public void TC_08() {
		newCustormer.pressKeyTabCity(Keys.TAB);
		verifyEqual(newCustormer.getTexCity(), "City Field must not be blank");
	}

//	9) Enter numeric value in CITY Field 1234 city123
	@Test
	public void TC_09() {
		newCustormer.inputNumberCity("1234");
		verifyEqual(newCustormer.getTexCity(), "Numbers are not allowed");
	}

//	10) Enter Special Character In CITY Field : City!@#
	@Test
	public void TC_10() {
		newCustormer.inputNumberCity("City!@#");
		verifyEqual(newCustormer.getTexCity(), "Special characters are not allowed");
	}

//	11) Enter First character Blank space
	@Test
	public void TC_11() {
		newCustormer.pressKeyTabCity(Keys.SPACE);
		verifyEqual(newCustormer.getTexCity(), "First character can not have space");
	}

//12 Verify State Field State cannot be empt1) Do not enter a value in STATE Field 2) Press TAB and move to next Field.An error message "State must not be blank" must be shown

	@Test
	public void TC_12() {
		newCustormer.pressKeyState(Keys.TAB);
		verifyEqual(newCustormer.getTexState(), "State must not be blank");
	}

//13	 State cannot be numeric 1) Enter numeric value in STATE Field  1234 State123	An error message "Numbers are not allowed" must be shown
	@Test
	public void TC_13() {
		newCustormer.inputNumberState("1234");
		verifyEqual(newCustormer.getTexState(), "Numbers are not allowed");
	}

//	14 State cannot have special character 1) Enter Special Character In STATE Field [State!@# !@#]//	An error message "Special characters are not allowed" must be shown
	@Test
	public void TC_14() {
		newCustormer.inputNumberState("State!@#");
		verifyEqual(newCustormer.getTexState(), "Special characters are not allowed");
	}

//	 15 State cannot have first blank space 1) Enter First character Blank space

	@Test
	public void TC_15() {
		newCustormer.pressKeyState(Keys.SPACE);
		verifyEqual(newCustormer.getTexState(), "First character can not have space");
	}

//16.1	 Verify PIN Field PIN must be numeric 1) Enter character value in PIN  Field//	1234 An error message "PIN Code must have 6 Digits " must be shown
	@Test
	public void TC_16_1() {
		newCustormer.inputNumberPin("1234");
		verifyEqual(newCustormer.getTexPin(), "PIN Code must have 6 Digits");
	}

//	16.2  input 1234PIN An error message "Characters are not allowed" must be shown

	@Test
	public void TC_16_2() {
		newCustormer.inputNumberPin("1234PIN");
		verifyEqual(newCustormer.getTexPin(), "Characters are not allowed");
	}

//	17 PIN cannot be empty//	1) Do not enter a value in PIN Field 2) Press TAB and move to next Field//	An error message "PIN code must not be blank" must be shown
	@Test
	public void TC_17() {
		newCustormer.pressKeyPin(Keys.TAB);
		verifyEqual(newCustormer.getTexPin(), "PIN Code must not be blank");
	}

	// 18 PIN must have 6 digits1) Enter More than 6 digit in PIN field 2) Enter//
	// Less Than 6 digit in PIN field 12 123 An error message "PIN Code must have
	// 6 Digits" must be shown
	@Test
	public void TC_18() {
		newCustormer.inputNumberPin("123");
		verifyEqual(newCustormer.getTexPin(), "PIN Code must have 6 Digits");
	}

//	19 PIN cannot have special character 1) Enter Special Character In PIN Field !@# 123!@# An error message "Special characters are not allowed" must be shown
	@Test
	public void TC_19() {
		newCustormer.inputNumberPin("123!@#");
		verifyEqual(newCustormer.getTexPin(), "Special characters are not allowed");
	}

	// 20. PIN cannot have first blank space 1) Enter First character Blank space An
	// error message "First character cannot be space" must be shown
	@Test
	public void TC_20() {
		newCustormer.pressKeyPin(Keys.SPACE);
		verifyEqual(newCustormer.getTexPin(), "First character can not have space");
	}

//	21 PIN cannot have blank space 1) Enter First character Blank space
//	An error message "PIN cannot have space" must be shown same 20
//22	 Verify Telephone Field Telephone cannot be empty 1) Do not enter a value in Telephone Field 2) Press TAB and move to next Field//	 An error message "Mobile no must not be blank" must be shown
	@Test
	public void TC_21() {
		newCustormer.pressKeyMobileNumber(Keys.TAB);
		verifyEqual(newCustormer.getTexMobileNumber(), "Mobile no must not be blank");
	}

//23	Telephone cannot have first character as blank space 1) Enter First character Blank space
//	An error message "First character cannot be space" must be shown
	@Test
	public void TC_22() {
		newCustormer.pressKeyMobileNumber(Keys.SPACE);
		verifyEqual(newCustormer.getTexMobileNumber(), "First character can not have space");
	}

//	24 Telephone cannot have spaces 1) Enter Blank space in Telephone 123 123
//	An error message "Telephone cannot have be space" must be shown
	@Test
	public void TC_24() {
		newCustormer.inputNumberMobileNumber("123 123");
		verifyEqual(newCustormer.getTexMobileNumber(), "Characters are not allowed");
	}

//25	Telephone cannot have special character 1) Enter Special Character In Telephone Field
//	886636!@12 !@88662682 88663682!@
//	An error message "Special characters are not allowed" must be shown
	@Test
	public void TC_25() {
		newCustormer.inputNumberMobileNumber("886636!@12");
		verifyEqual(newCustormer.getTexMobileNumber(), "Special characters are not allowed");
	}

//26	Verify Email Field Email cannot be empty
//	1) Do not enter a value in Email Field 2) Press TAB and move to next Field
//	An error message "Email ID must not be blank" must be shown
	@Test
	public void TC_26() {
		newCustormer.pressKeyEmail(Keys.TAB);
		verifyEqual(newCustormer.getTexEmail(), "Email-ID must not be blank");
	}

//	27 Email must be in correct format Enter invalid email in Email field
//	 guru99@gmail guru99 Guru99@ guru99@gmail. guru99gmail. com
//	 An error message "Email-ID is not valid"" must be shown
	@Test
	public void TC_27_1() {
		newCustormer.inputNumberEmail("guru99@gmail");
		verifyEqual(newCustormer.getTexEmail(), "Email-ID is not valid");
	}

	@Test
	public void TC_27_2() {
		newCustormer.inputNumberEmail("guru99");
		verifyEqual(newCustormer.getTexEmail(), "Email-ID is not valid");
	}

	@Test
	public void TC_27_3() {
		newCustormer.inputNumberEmail("Guru99@");
		verifyEqual(newCustormer.getTexEmail(), "Email-ID is not valid");
	}

	@Test
	public void TC_27_4() {
		newCustormer.inputNumberEmail("guru99@gmail.");
		verifyEqual(newCustormer.getTexEmail(), "Email-ID is not valid");
	}

	@Test
	public void TC_27_5() {
		newCustormer.inputNumberEmail("guru99gmail. com");
		verifyEqual(newCustormer.getTexEmail(), "Email-ID is not valid");
	}
//	29 Email cannot have space 1) Enter Blank space in Email //	An error message "Email-ID is not valid" must be shown
	@Test
	public void TC_29() {
		newCustormer.pressKeyEmail(Keys.SPACE);
		verifyEqual(newCustormer.getTexEmail(), "First character can not have space");
	}
//	30.Verify Field LabelsCheck all Fields name(Label) are as documented in SRS for all modules Cross check Field names with that in SRS Field names in SRS and system should match
	@Test
	public void TC_30() {
	newCustormer.inputNumberCustomerName("xuan");
	newCustormer.inputDateOfBirth("26/10/1994"); 
	newCustormer.inputAddress("Tân Hiệp Hóc Môn");
	newCustormer.inputNumberCity("Hồ Chí Minh");
	newCustormer.inputNumberState("Hồ Chí Minh");
	newCustormer.inputNumberPin("261019");
	newCustormer.inputNumberMobileNumber("098686868");
	newCustormer.inputNumberEmail("hoangharu@gmail.com");
	newCustormer.inputPassWord("12345678");
	newCustormer.clickSummit();
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
