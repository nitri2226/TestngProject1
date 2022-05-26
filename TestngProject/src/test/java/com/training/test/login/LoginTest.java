package com.training.test.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class LoginTest extends BaseTest {

	WebDriver driver;
	LoginPage login;
	HomePage home;
	CommonUtilities common = new CommonUtilities();

	@BeforeMethod
	public void beforeTest() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);

	}

	@Test(description = "Login Error Message - 1")
	public void LoginErrorMessage1() throws Exception {

		String Username = common.getApplicationProperty("Username");
		String wrongPassword = common.getApplicationProperty("wrongPassword");
		BaseTest.enterText(login.Username(), Username);
		BaseTest.enterText(login.enterIntoPassword(), wrongPassword);
		BaseTest.clickObj(login.LoginButton(), "Login");
		String errormessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		if (errormessage.equals("Please enter your password.")) {
			System.out.println("Error message is been be displayed");
		} else {
			System.out.println("Error message is not been be displayed");
		}

	}

	@Test(description = "Login To SalesForce -2")
	public void LoginToSalesForce2() throws Exception {

		String Username = common.getApplicationProperty("Username");
		BaseTest.enterText(login.Username(), Username);
		String Password = common.getApplicationProperty("password");
		BaseTest.enterText(login.enterIntoPassword(), Password);
		BaseTest.selectCheckBox(login.checkRememberme(), "RememberMe");
		BaseTest.clickObj(login.LoginButton(), "Login");
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("User is on home page");
		else
			System.out.println("home page is not Lunched");
	}

	@Test(description = "Check RemeberMe - 3")
	public void Check_RemeberMe_3() throws Exception {
		String Username = common.getApplicationProperty("Username");
		BaseTest.enterText(login.Username(), Username);
		String Password = common.getApplicationProperty("password");
		BaseTest.enterText(login.enterIntoPassword(), Password);
		BaseTest.selectCheckBox(login.checkRememberme(), "RememberMe");
		BaseTest.clickObj(login.LoginButton(), "Login");
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("User is on home page");
		else
			System.out.println("home page is not Lunched");
	}
	
	@Test(description = "Forgot Password- 4A")
	public void Forgot_Password_4_A() throws Exception {
		String Username = common.getApplicationProperty("Username");
		BaseTest.enterText(login.Username(), Username);
		BaseTest.clickObj(login.forgotPassword(), "ForgotPassword");
		String Fname = common.getApplicationProperty("Email");
		BaseTest.enterText(login.fullName(), Fname);
		BaseTest.clickObj(login.Continue(), "Continue");
	}
	
	@Test(description = "Forgot Password- 4B")
	public void Forgot_Password_4_B() throws Exception {
		String Username = common.getApplicationProperty("Username");
		BaseTest.enterText(login.Username(), Username);
		String Password = common.getApplicationProperty("wrongPassword");
		BaseTest.enterText(login.enterIntoPassword(), Password);
		BaseTest.clickObj(login.LoginButton(), "Login");
		String ErrorText = common.getApplicationProperty("errormessage");
		BaseTest.validateErrormsg(login.errormessage().getText(), ErrorText);
	}

	@AfterMethod
	public void teardown() throws IOException {
				driver.close();

	}

}
