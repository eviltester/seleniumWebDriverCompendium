package com.eviltester.webinar.tracks.login;


import com.eviltester.webinar.tracks.domain.TracksAccount;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {

    public static final String TRACKS_LOGIN_URL = "/tracks/login";
    public static final String TRACKS_LOGOUT_URL = "/tracks/logout";

    public static WebDriver driver;
    private TracksAccount tracks;

    @BeforeClass
    public static void startDriver(){
        driver = new FirefoxDriver();
    }


    @Before
    public void prepForTest(){
        tracks = new TracksAccount();
    }

    @Test
    public void loginToTracks(){
        // get tracks details

        final String TRACKS_LOGIN = tracks.tracks_url + TRACKS_LOGIN_URL;

        // goto login page
        driver.get(TRACKS_LOGIN);

        // actually login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName(tracks.userName);
        loginPage.typePassword(tracks.password);
        loginPage.signIn();

        // check logged in
        assertThat(driver.getTitle(), is("TRACKS::List tasks"));

    }


    @Test
    public void failToLoginToTracks(){
        // get tracks details

        final String TRACKS_LOGIN = tracks.tracks_url + TRACKS_LOGIN_URL;

        // goto login page
        driver.get(TRACKS_LOGIN);

        // actually login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName(tracks.userName);
        loginPage.typePassword("bob");
        loginPage.signIn();

        // check still at login page
        assertThat(driver.getCurrentUrl(), endsWith(TRACKS_LOGIN_URL));
        assertThat(loginPage.loginUnsuccessfulMessageIsPresent(), is(true));


    }


    @After
    public void closeSession(){
        // logout
        driver.get(tracks.tracks_url + TRACKS_LOGOUT_URL);
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}





























