package com.webstudio.easybrowser.models;

public class Profile {
    public String name;
    public String proxy;
    public String deviceModel;
    public String userAgent;
    public String timezone;
    public double latitude;
    public double longitude;
    public String locale;

    public Profile() {
        this.name = "default";
        this.proxy = "";
        this.deviceModel = "Samsung Galaxy S23 Ultra";
        this.userAgent = "Mozilla/5.0 (Linux; Android 13; SM-S918B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36";
        this.timezone = "America/New_York";
        this.latitude = 40.7128;
        this.longitude = -74.0060;
        this.locale = "en-US";
    }
}