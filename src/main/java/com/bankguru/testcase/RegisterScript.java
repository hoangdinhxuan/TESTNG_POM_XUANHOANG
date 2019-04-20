package com.bankguru.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.RegisterPage;

import CommonPage.Commontestcase;

public class RegisterScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	String email;
	static String emailLogin, passwordLogin;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		email = "hoangxuan" + randomEmail() + "@gmail.com";
		inititalReport("Register.html");

	}

	@Test
	public void TC_01() {
		logTestCase("Loginpage");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = loginPage.clickHereLink();
		registerPage.inputEmailRegister(email);
		registerPage.clickSumit();
		emailLogin = registerPage.getUsername();
		passwordLogin = registerPage.getPasswork();
		// loginPage = new LoginPage(driver);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}
	@AfterClass
	public void afterClass() {
		exportReport();
		closeBrowser();
	}
}
