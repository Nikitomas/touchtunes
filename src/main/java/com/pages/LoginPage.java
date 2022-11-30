package com.pages;

import org.openqa.selenium.WebDriver;

import com.components.se.elements.BasePage;
import com.components.se.elements.IBaseElement;
import com.components.se.enums.Until;
import com.components.se.implement.CustomFindBy;
import com.exception.FrameworkException;

public class LoginPage extends BasePage {

	@CustomFindBy(css="button[data-testid='login-button']", waitFor = Until.Clickable)
	public IBaseElement loginBtn;
	
	@CustomFindBy(css="input[data-testid='login-username']", waitFor = Until.Visible)
	public IBaseElement userName;

	@CustomFindBy(css="input[data-testid='login-password']", waitFor = Until.Visible)
	public IBaseElement password;
	
	@CustomFindBy(css="div[role='alert']", waitFor = Until.Visible)
	public IBaseElement wrongLoginAlert;
	
	public LandingPage login() throws FrameworkException {
		loginBtn.click();
		userName.setText("nicolas.touma@gmail.com");
		password.setText("1234abcd!");
		loginBtn.click();
		return new LandingPage(driver);
	}
	
	public LandingPage faultyLogin() throws FrameworkException {
		loginBtn.click();
		userName.setText("hokusbokus");
		password.setText("abracadabra");
		loginBtn.click();
		return new LandingPage(driver);
	}

	public LoginPage(WebDriver driver) throws FrameworkException {
		super(driver);
	}
}