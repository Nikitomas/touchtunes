package com.touchtunes.touchtunetest;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.config.BaseUITest;
import com.exception.FrameworkException;
import com.pages.CreatePlayListPage;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.pages.PlaylistPage;

public class AppTest extends BaseUITest {
/*
 * Normally, i would use an API call to make sure that all previously created playlists 
 * are deleted and make sure to delete the one that this test creates but i don't have
 * that access now.
 * */
	@Test(groups = { "Qa-Exercise" })
	public void testCreatePlayList() throws FrameworkException, InterruptedException {
		
		reporter.info("Logging into the application");
		LoginPage login = new LoginPage(driver);
		LandingPage landingPage = new LandingPage(driver);
		landingPage = login.login();
		
		reporter.info("Creating a playlist");
		CreatePlayListPage createListPage = new CreatePlayListPage(driver);
		createListPage=landingPage.createPlayList();
		
		reporter.info("Search a song");
		PlaylistPage playListPage;
		playListPage = createListPage.searchForASong("Taka");
		
		reporter.info("Adding a song and playing it");
		playListPage.addSongToPlayListAndPlayIt();
		assertion.shouldBeEqual(playListPage.validatePauseBtn(), true,"The pause button is present which means the song is playing.");
		
		reporter.info("Logging out");
		new LandingPage(driver).logout();
	}
	
	@Test(groups = { "Negative-Tests" })
	public void loginFailsWithWrongInput() throws FrameworkException, InterruptedException {
		
		reporter.info("Logging into the application with bad credentials");
		LoginPage login = new LoginPage(driver);
		LandingPage landingPage = new LandingPage(driver);
		landingPage = login.faultyLogin();
		
		reporter.info("Adding a song and playing it");
		assertion.shouldBeEqual(login.wrongLoginAlert.isPresent(), true,"The bad login alert message is shown.");	
	}
}