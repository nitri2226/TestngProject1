package com.training.test.home;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	CommonUtilities common = new CommonUtilities();

	@BeforeMethod
	public void beforeTest() throws Exception {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		String Username = common.getApplicationProperty("Username");
		BaseTest.enterText(login.Username(), Username);
		String Password = common.getApplicationProperty("pwd");
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
	
	@Test(description = "TC_5_Selectusermenudropdown")
	public void TC_5_Selectusermenudropdown() throws Exception {
		
		BaseTest.clickObj(home.Username(), "Usermenu");
		String dropdownverify=driver.findElement(By.xpath("//div[@id='userNav-menuItems']")).getText();
		System.out.println(dropdownverify);
		
	}
	
	@Test(description = "TC_6_SelectMyProfile")
	public void TC_6_SelectMyProfile() throws Exception {
		
		BaseTest.clickObj(home.Username(), "Usermenu");
		String dropdownverify=driver.findElement(By.xpath("//div[@id='userNav-menuItems']")).getText();
		System.out.println(dropdownverify);
		
	}


}
