package com.eviltester.webinar.tracks.domain;

public class TracksAccount {

    private static final String TRACKS_USERNAME_KEY = "TRACKS_USERNAME_KEY";
    private static final String TRACKS_PASSWORD_KEY = "TRACKS_PASSWORD_KEY";
    private static final String TRACKS_URL_KEY = "TRACKS_URL";

    public final String password;
    public final String userName;
    public final String tracks_url;



    public TracksAccount(){
        userName = System.getProperty(TRACKS_USERNAME_KEY, "user");
        password = System.getProperty(TRACKS_PASSWORD_KEY, "password");
        tracks_url = System.getProperty(TRACKS_URL_KEY, "http://192.168.1.171:800");
    }
}
