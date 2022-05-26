package com.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='username']")
    WebElement Uname;
	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;
	@FindBy(xpath = "//div[@id='error']")
	WebElement errormessage;
	@FindBy(xpath = "//*[@id='Login']")
	WebElement login;
	@FindBy(xpath = "//*[@id='rememberUn']")
	WebElement remember;
	@FindBy(xpath = "//*[@id='forgot_password_link']")
	WebElement Fpwd;
	@FindBy(xpath = ".//*[@id='un']")
	WebElement Fname;
	@FindBy(xpath = "//*[@id='continue']")
	WebElement Conti;
	@FindBy(xpath="//div[@id='error']")
	WebElement actualText;
	 

	public WebElement errormessage() {
		return actualText;
	}
	public WebElement Username() {
		return Uname;
	}

	public WebElement enterIntoPassword() {
		return pwd;
	}

	public WebElement checkRememberme() {
		return remember;
	}

	public WebElement LoginButton() {
		return login;
	}
	public WebElement forgotPassword() {
		return Fpwd;
	}
	public WebElement fullName() {
		return Fname;
	}
	public WebElement Continue() {
		return Conti;
	}

	public void logintapplication(String strusername, String strpassword) {
		Uname.sendKeys(strusername);
		pwd.sendKeys(strpassword);
		login.click();
	}

}
