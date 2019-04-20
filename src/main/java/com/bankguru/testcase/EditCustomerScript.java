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
import ObjectPageJson.JsonData;

public class EditCustomerScript<NewCustomer> extends Commontestcase {
    WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustomer newCustomer;
	EditCustomer editCustomer;
	JsonData data;
	String email;
	static String customerId;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		data = getDataJson(".\\Data\\BankGuru.json");

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
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getMessegercustomerID()),
				data.ExpectedMsgPage().getMessegercustomerID());
	}

//	2.Customer id must be numeric1) Enter character value in Customer idField 1234Ac /cAcc123
//	An error messag "Characters are not allowed" must be shown
	@Test
	public void TC_02() {
		editCustomer.inputCustomerId(data.EditCustomerPage().getCustomerIDnumberandCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCustomerIDmustBeNumbericMsg()),
				data.ExpectedMsgPage().getCustomerIDmustBeNumbericMsg());
	}

	// 3.Customer id cannot have special character 1) Enter Special Character In
	// Customer id Field 123!@# !@# An error message "Special characters are not
	// allowed" must be shown
	@Test
	public void TC_03() {
		editCustomer.inputCustomerId(data.EditCustomerPage().getCustomerIDspecialCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());
	}

//	4 Valid Customer Id
//	1) Enter valid Customer id
//	2) Submit xyz Edit Customer successfully
	@Test
	public void TC_04() {
		editCustomer.inputCustomerId(data.EditCustomerPage().getCustomerIDCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getMustBeNumbericMsg()),
				data.ExpectedMsgPage().getMustBeNumbericMsg());
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
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getAddressCannotEmptyMsg()),
				data.ExpectedMsgPage().getAddressCannotEmptyMsg());

	}

	// 9.Verify Address Field Address cannot be empty
//	1) Do not enter a value in ADDRESS Field 2) Press clear to  Field
//	An error message "Address Field must not be blank" must be shown , presskeyTab Address An error message "Email-ID must not be blank"
	@Test
	public void TC_09() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearAddress();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getAddressCannotEmptyMsg()),
				data.ExpectedMsgPage().getAddressCannotEmptyMsg());
		editCustomer.pressKeyTabAddress(Keys.TAB);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getAddressCannotEmptyMsg()),
				data.ExpectedMsgPage().getAddressCannotEmptyMsg());
	}

	//
//	10.	inputaddress @#^%#^%^
	@Test
	public void TC_10() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearAddress();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getAddressCannotEmptyMsg()),
				data.ExpectedMsgPage().getAddressCannotEmptyMsg());
		editCustomer.inputAddress(data.EditCustomerPage().getAddressspecialCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());

	}
////	11.	 City cannot be empty 1) Do not enter a value in CITY Field 2) Press TAB and move to next Field Do not enter a value in CITY Field 2) Press TAB and SPace and move to next Field

	@Test
	public void TC_11() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearCity();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCityCannotEmptyMsg()),
				data.ExpectedMsgPage().getCityCannotEmptyMsg());
		editCustomer.pressKeyTabCity(Keys.SPACE);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		editCustomer.clearCity();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCityCannotEmptyMsg()),
				data.ExpectedMsgPage().getCityCannotEmptyMsg());
		editCustomer.pressKeyTabCity(Keys.TAB);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCityCannotEmptyMsg()),
				data.ExpectedMsgPage().getCityCannotEmptyMsg());

	}

//	 12 Enter numeric value in CITY Field 1234 city123
	@Test
	public void TC_12() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearCity();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCityCannotEmptyMsg()),
				data.ExpectedMsgPage().getCityCannotEmptyMsg());
		editCustomer.inputNumberCity(data.EditCustomerPage().getCitynumber());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCityNotBeNumbericMsg()),
				data.ExpectedMsgPage().getCityNotBeNumbericMsg());
		// Enter Special Character In CITY Field : City!@#
		editCustomer.clearCity();
		editCustomer.inputNumberCity(data.EditCustomerPage().getCityspecialCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());

	}
	// 13.Verify State Field State cannot be empt1) Do not enter a value in STATE
	// Field 2) Press TAB and move to next Field.An error message "State must not be
	// blank" must be shown

	public void TC_13() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearState();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getStateCannotEmptyMsg()),
				data.ExpectedMsgPage().getStateCannotEmptyMsg());
		editCustomer.pressKeyState(Keys.SPACE);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		editCustomer.clearState();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getStateCannotEmptyMsg()),
				data.ExpectedMsgPage().getStateCannotEmptyMsg());
		editCustomer.pressKeyState(Keys.TAB);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getStateCannotEmptyMsg()),
				data.ExpectedMsgPage().getStateCannotEmptyMsg());

	}

//14 input valua 1234, State!@#
	@Test
	public void TC_14() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearState();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getStateCannotEmptyMsg()),
				data.ExpectedMsgPage().getStateCannotEmptyMsg());
		editCustomer.inputState(data.EditCustomerPage().getStatenumber());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getStateNotBeNumbericMsg()),
				data.ExpectedMsgPage().getStateNotBeNumbericMsg());
		// Enter Special Character In State Field : City!@#
		editCustomer.clearState();
		editCustomer.inputState(data.EditCustomerPage().getStatespecialCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());

	}

	// PIN
	public void TC_15() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearPin();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getPinCannotEmptyMsg()),
				data.ExpectedMsgPage().getPinCannotEmptyMsg());
		editCustomer.pressKeyPin(Keys.SPACE);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		editCustomer.clearState();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getPinCannotEmptyMsg()),
				data.ExpectedMsgPage().getPinCannotEmptyMsg());
		editCustomer.pressKeyPin(Keys.TAB);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getPinCannotEmptyMsg()),
				data.ExpectedMsgPage().getPinCannotEmptyMsg());

	}

//16 input valua 1234, Pin!@#
	@Test
	public void TC_16() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearPin();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getPinCannotEmptyMsg()),
				data.ExpectedMsgPage().getPinCannotEmptyMsg());
		editCustomer.inputNumberPin(data.EditCustomerPage().getPinnumbernotenough());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getPinMustHave6DigitsMsg()),
				data.ExpectedMsgPage().getPinMustHave6DigitsMsg());
		// Enter Special Character In State Field : Pin!@#
		editCustomer.clearPin();
		editCustomer.inputNumberPin(data.EditCustomerPage().getPinspecialCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());

	}

	// MOBIle
	public void TC_17() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearMobileNumber();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getMobileNumberCannotEmptyMsg()),
				data.ExpectedMsgPage().getMobileNumberCannotEmptyMsg());
		editCustomer.pressKeyMobileNumber(Keys.SPACE);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		editCustomer.clearMobileNumber();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getMobileNumberCannotEmptyMsg()),
				data.ExpectedMsgPage().getMobileNumberCannotEmptyMsg());
		editCustomer.pressKeyTabCity(Keys.TAB);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getMobileNumberCannotEmptyMsg()),
				data.ExpectedMsgPage().getMobileNumberCannotEmptyMsg());
	}

	// 18 input valua 1234, mobile!@#
	@Test
	public void TC_18() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearMobileNumber();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getMobileNumberCannotEmptyMsg()),
				data.ExpectedMsgPage().getMobileNumberCannotEmptyMsg());
		editCustomer.inputNumberMobileNumber(data.EditCustomerPage().getMobileNumbervalid());
		// Enter Special Character In State Field : "hfhhh"
		editCustomer.clearMobileNumber();
		editCustomer.inputNumberMobileNumber(data.EditCustomerPage().getMobileCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getMustBeNumbericMsg()),
				data.ExpectedMsgPage().getMustBeNumbericMsg());
		// Enter Special Character In State Field : "mobile!@#"
		editCustomer.clearMobileNumber();
		editCustomer.inputNumberMobileNumber(data.EditCustomerPage().getMobilespecialCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getCannotSpecialCharacterMsg()),
				data.ExpectedMsgPage().getCannotSpecialCharacterMsg());
	}

	// 19 EMAil
	public void TC_19() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearEmail();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		editCustomer.pressKeyEmail(Keys.SPACE);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getFirstCharacterBlankSpaceMsg()),
				data.ExpectedMsgPage().getFirstCharacterBlankSpaceMsg());
		editCustomer.clearEmail();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		editCustomer.pressKeyEmail(Keys.TAB);
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());

	}

	// 20 input valua 1234, mobile!@#
	@Test
	public void TC_20() {
		editCustomer.inputCustomerId(NewCustomerScript.customerId);
		editCustomer.clickSummit();
		editCustomer.clearEmail();
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getEmailCannotEmptyMsg()),
				data.ExpectedMsgPage().getEmailCannotEmptyMsg());
		editCustomer.inputEmail(data.EditCustomerPage().getEmailNumberic());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getEmailInputWrongMsg()),
				data.ExpectedMsgPage().getEmailInputWrongMsg());
		editCustomer.clearEmail();
		editCustomer.inputEmail(data.EditCustomerPage().getEmailnotcom());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getEmailInputWrongMsg()),
				data.ExpectedMsgPage().getEmailInputWrongMsg());
		// Enter Special Character In State Field : "mobile!@#"
		editCustomer.clearEmail();
		editCustomer.inputEmail(data.EditCustomerPage().getEmailspecialCharacter());
		verifyEqual(editCustomer.getDynamicText(data.EditCustomerPage().getEmailInputWrongMsg()),
				data.ExpectedMsgPage().getEmailInputWrongMsg());
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}