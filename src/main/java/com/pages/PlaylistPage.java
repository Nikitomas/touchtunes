package com.pages;

import org.openqa.selenium.WebDriver;

import com.components.se.elements.BasePage;
import com.components.se.elements.IBaseElement;
import com.components.se.enums.Until;
import com.components.se.implement.CustomFindBy;
import com.exception.FrameworkException;

public class PlaylistPage extends BasePage{


	@CustomFindBy(css="button[data-testid='add-to-playlist-button']", waitFor = Until.Clickable)
	public IBaseElement addSong;
	
	@CustomFindBy(css="button[data-testid='play-button']",waitFor = Until.Present)
	public IBaseElement playMusicBtn;
	
	@CustomFindBy(css="span[data-testid='entityTitle']",waitFor = Until.Visible)
	public IBaseElement playListTitle;
	
	@CustomFindBy(css="button[aria-label='Pause']",waitFor = Until.Present)
	public IBaseElement pauseBtn;
	
	@CustomFindBy(id="onetrust-close-btn-container",waitFor = Until.Visible)
	public IBaseElement cookiesMessageCloseBtn;
	
	public PlaylistPage addSongToPlayListAndPlayIt() throws FrameworkException {
		addSong.click();
		playMusicBtn.clickAsJScript();
		cookiesMessageCloseBtn.click();
		return new PlaylistPage(driver);
	}
	
	public boolean validatePauseBtn() {
		return pauseBtn.isPresent();
	}
	
	public PlaylistPage(WebDriver driver) throws FrameworkException {
		super(driver);
	}
}