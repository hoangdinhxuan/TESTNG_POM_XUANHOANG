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
//12 Verify State Field State cannot be empt1) Do not enter a value in STATE Field 2) Press TAB and move to next Field

	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
