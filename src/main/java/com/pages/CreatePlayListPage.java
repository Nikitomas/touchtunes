package com.pages;

import org.openqa.selenium.WebDriver;

import com.components.se.elements.BasePage;
import com.components.se.elements.IBaseElement;
import com.components.se.enums.Until;
import com.components.se.implement.CustomFindBy;
import com.exception.FrameworkException;

public class CreatePlayListPage extends BasePage{

	@CustomFindBy(css="input[role='searchbox']", waitFor = Until.Clickable)
	public IBaseElement songSearchBox;

	public PlaylistPage searchForASong(String songName) throws FrameworkException, InterruptedException {
		songSearchBox.setText(songName);
		return new PlaylistPage(driver);
	}

	public CreatePlayListPage(WebDriver driver) throws FrameworkException {
		super(driver);
	}
}