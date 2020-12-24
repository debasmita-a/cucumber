package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	//maintain By locators(private), constructor, create page actions(public)-using concepts of encapsulation
	//By locators: OR:
	private By email_id = By.id("email");
	private By password = By.id("passwd");
	private By submitLogin = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?111");
	
	//Constructor of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page actions: features(behavior) of the page the form of methods:
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkAvailable() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(email_id).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(submitLogin).click();
	}
	
}
