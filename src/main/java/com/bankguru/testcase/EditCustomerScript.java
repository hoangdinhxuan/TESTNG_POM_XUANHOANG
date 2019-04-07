package com.bankguru.testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.EditCustomer;
import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;

import com.bankguru.actions.RegisterPage;

import CommonPage.Commontestcase;

public class EditCustomerScript<NewCustomer> extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustomer newCustomer;
	EditCustomer editCustomer;
	String email;
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
		editCustomer = homePage.clickMenuEditCustomer();

	}

	@Test
	// 1.Verify Customer idCustomer id cannot b empty1) Do not enter a value in
	// Customer id Field2) Press TAB and move to next FieldAn error message
	// "CustomerID is required" must be shown

	public void TC_01() {
		editCustomer.pressKeyTabCustomerId(Keys.TAB);
		verifyEqual(editCustomer.getTexCustomerId(), "Customer ID is required");
	}

//	2.Customer id must be numeric1) Enter character value in Customer idField 1234Ac /cAcc123
//	An error messag "Characters are not allowed" must be shown
	@Test
	public void TC_02() {
		editCustomer.inputCustomerId("1234Ac");
		verifyEqual(editCustomer.getTexCustomerId(), "Characters are not allowed");
	}

	// 3.Customer id cannot have special character 1) Enter Special Character In
	// Customer id Field 123!@# !@# An error message "Special characters are not
	// allowed" must be shown
	@Test
	public void TC_03() {
		editCustomer.inputCustomerId("123!@#");
		verifyEqual(editCustomer.getTexCustomerId(), "Special characters are not allowed");
	}

//	4 Valid Customer Id
//	1) Enter valid Customer id
//	2) Submit xyz Edit Customer successfully
	@Test
	public void TC_04() {
		editCustomer.inputCustomerId("xyz");
		verifyEqual(editCustomer.getTexCustomerId(), "Characters are not allowed");
	}

//	5 Valid Customer Id
//	1) Enter valid Customer id
//	2) Submit Edit Customer successfully

	@Test
	public void TC_05() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
	}
//	}
//	8.Verify Address Field Address cannot be empty
//	1) Do not enter a value in ADDRESS Field 2) Press clear to  Field
//	An error message "Address Field must not be blank" must be shown

	@Test
	public void TC_08() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearAddress();
		verifyEqual(editCustomer.getTexAddress(), "Address Field must not be blank");

	}

	// 9.Verify Address Field Address cannot be empty
//	1) Do not enter a value in ADDRESS Field 2) Press clear to  Field
//	An error message "Address Field must not be blank" must be shown , presskeyTab Address An error message "Email-ID must not be blank"
	@Test
	public void TC_09() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearAddress();
		verifyEqual(editCustomer.getTexAddress(), "Address Field must not be blank");
		editCustomer.pressKeyTabAddress(Keys.TAB);
		verifyEqual(editCustomer.getTexAddress(), "Address Field must not be blank");
	}

	//
//	10.	inputaddress @#^%#^%^
	@Test
	public void TC_10() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearAddress();
		verifyEqual(editCustomer.getTexAddress(), "Address Field must not be blank");
		editCustomer.inputAddress("@#^%#^%^");
		verifyEqual(editCustomer.getTexAddress(), "Special characters are not allowed");

	}
////	11.	 City cannot be empty 1) Do not enter a value in CITY Field 2) Press TAB and move to next Field Do not enter a value in CITY Field 2) Press TAB and SPace and move to next Field

	@Test
	public void TC_11() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearCity();
		verifyEqual(editCustomer.getTexCity(), "City Field must not be blank");
		editCustomer.pressKeyTabCity(Keys.SPACE);
		verifyEqual(editCustomer.getTexCity(), "First character can not have space");
		editCustomer.clearCity();
		verifyEqual(editCustomer.getTexCity(), "City Field must not be blank");
		editCustomer.pressKeyTabCity(Keys.TAB);
		verifyEqual(editCustomer.getTexCity(), "City Field must not be blank");

	}

//	 12 Enter numeric value in CITY Field 1234 city123
	@Test
	public void TC_12() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearCity();
		verifyEqual(editCustomer.getTexCity(), "City Field must not be blank");
		editCustomer.inputNumberCity("1234");
		verifyEqual(editCustomer.getTexCity(), "Numbers are not allowed");
		// Enter Special Character In CITY Field : City!@#
		editCustomer.clearCity();
		editCustomer.inputNumberCity("City!@#");
		verifyEqual(editCustomer.getTexCity(), "Special characters are not allowed");

	}
	// 13.Verify State Field State cannot be empt1) Do not enter a value in STATE
	// Field 2) Press TAB and move to next Field.An error message "State must not be
	// blank" must be shown

	public void TC_13() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearState();
		verifyEqual(editCustomer.getTexState(), "State must not be blank");
		editCustomer.pressKeyState(Keys.SPACE);
		verifyEqual(editCustomer.getTexState(), "First character can not have space");
		editCustomer.clearState();
		verifyEqual(editCustomer.getTexState(), "State must not be blank");
		editCustomer.pressKeyState(Keys.TAB);
		verifyEqual(editCustomer.getTexState(), "State must not be blank");

	}

//14 input valua 1234, State!@#
	@Test
	public void TC_14() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearState();
		verifyEqual(editCustomer.getTexState(), "State must not be blank");
		editCustomer.inputState("1234");
		verifyEqual(editCustomer.getTexState(), "Numbers are not allowed");
		// Enter Special Character In State Field : City!@#
		editCustomer.clearState();
		editCustomer.inputState("State!@#");
		verifyEqual(editCustomer.getTexState(), "Special characters are not allowed");

	}

	// PIN
	public void TC_15() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearPin();
		verifyEqual(editCustomer.getTexPin(), "PIN Code must not be blank");
		editCustomer.pressKeyPin(Keys.SPACE);
		verifyEqual(editCustomer.getTexPin(), "First character can not have space");
		editCustomer.clearState();
		verifyEqual(editCustomer.getTexPin(), "PIN Code must not be blank");
		editCustomer.pressKeyPin(Keys.TAB);
		verifyEqual(editCustomer.getTexPin(), "PIN Code must not be blank");

	}

//16 input valua 1234, Pin!@#
	@Test
	public void TC_16() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearPin();
		verifyEqual(editCustomer.getTexPin(), "PIN Code must not be blank");
		editCustomer.inputNumberPin("1234");
		verifyEqual(editCustomer.getTexPin(), "PIN Code must have 6 Digits");
		// Enter Special Character In State Field : Pin!@#
		editCustomer.clearPin();
		editCustomer.inputNumberPin("Pin!@#");
		verifyEqual(editCustomer.getTexPin(), "Special characters are not allowed");

	}
	// MOBIle
		public void TC_17() {
			editCustomer.inputCustomerId(NewCustomerScript.customerId);
			editCustomer.clickSummit();
			editCustomer.clearMobileNumber();
			verifyEqual(editCustomer.getTexMobileNumber(), "Mobile no must not be blank");
			editCustomer.pressKeyMobileNumber(Keys.SPACE);
			verifyEqual(editCustomer.getTexMobileNumber(), "First character can not have space");
			editCustomer.clearMobileNumber();
			verifyEqual(editCustomer.getTexMobileNumber(), "Mobile no must not be blank");
			editCustomer.pressKeyTabCity(Keys.TAB);
			verifyEqual(editCustomer.getTexMobileNumber(), "Mobile no must not be blank");

		}

	//18 input valua 1234, mobile!@#
		@Test
		public void TC_18() {
			editCustomer.inputCustomerId(NewCustomerScript.customerId);
			editCustomer.clickSummit();
			editCustomer.clearMobileNumber();
			verifyEqual(editCustomer.getTexMobileNumber(), "Mobile no must not be blank");
			editCustomer.inputNumberMobileNumber("1234");
			// Enter Special Character In State Field : "hfhhh"
			editCustomer.clearMobileNumber();
			editCustomer.inputNumberMobileNumber("hfhhh");
			verifyEqual(editCustomer.getTexMobileNumber(), "Characters are not allowed");
			// Enter Special Character In State Field : "mobile!@#"
			editCustomer.clearMobileNumber();
			editCustomer.inputNumberMobileNumber("mobile!@#");
			verifyEqual(editCustomer.getTexMobileNumber(), "Special characters are not allowed");
		}

		// 19 EMAil
				public void TC_19() {
					editCustomer.inputCustomerId(NewCustomerScript.customerId);
					editCustomer.clickSummit();
					editCustomer.clearEmail();
					verifyEqual(editCustomer.getTexEmail(), "Email-ID must not be blank");
					editCustomer.pressKeyEmail(Keys.SPACE);
					verifyEqual(editCustomer.getTexEmail(), "First character can not have space");
					editCustomer.clearEmail();
					verifyEqual(editCustomer.getTexEmail(), "Email-ID must not be blank");
					editCustomer.pressKeyEmail(Keys.TAB);
					verifyEqual(editCustomer.getTexEmail(), "Email-ID must not be blank");

				}

			//20 input valua 1234, mobile!@#
				@Test
				public void TC_20() {
					editCustomer.inputCustomerId(NewCustomerScript.customerId);
					editCustomer.clickSummit();
					editCustomer.clearEmail();
					verifyEqual(editCustomer.getTexEmail(), "Email-ID must not be blank");
					editCustomer.inputEmail("1234");
					verifyEqual(editCustomer.getTexEmail(), "Email-ID is not valid");
					editCustomer.clearEmail();
					editCustomer.inputEmail("hfhhh@gmail.");
					verifyEqual(editCustomer.getTexEmail(), "Email-ID is not valid");
					// Enter Special Character In State Field : "mobile!@#"
					editCustomer.clearEmail();
					editCustomer.inputEmail("email!@#");
					verifyEqual(editCustomer.getTexEmail(), "Email-ID is not valid");
				}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}