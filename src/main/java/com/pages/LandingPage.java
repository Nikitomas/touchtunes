package com.pages;

import org.openqa.selenium.WebDriver;

import com.components.se.elements.BasePage;
import com.components.se.elements.IBaseElement;
import com.components.se.enums.Until;
import com.components.se.implement.CustomFindBy;
import com.exception.FrameworkException;

public class LandingPage extends BasePage{

	@CustomFindBy(css="button[data-testid='create-playlist-button']", waitFor = Until.Clickable)
	public IBaseElement createPlayListBtn;

	@CustomFindBy(css="button[data-testid='user-widget-link']", waitFor = Until.Clickable)
	public IBaseElement userMenu;
	
	@CustomFindBy(css="button[data-testid='user-widget-dropdown-logout']", waitFor = Until.Clickable)
	public IBaseElement logoutBtn;
		
	public CreatePlayListPage createPlayList() throws FrameworkException {
		createPlayListBtn.click();
		return new CreatePlayListPage(driver);
	}
	
	public void logout() throws FrameworkException {
		userMenu.click();
		logoutBtn.click();
	}

	public LandingPage(WebDriver driver) throws FrameworkException {
		super(driver);
	}
}