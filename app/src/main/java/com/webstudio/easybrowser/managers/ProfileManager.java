package com.webstudio.easybrowser.managers;

import android.content.Context;
import android.content.SharedPreferences;
import com.webstudio.easybrowser.models.Profile;
import org.json.JSONObject;

public class ProfileManager {

    private static final String PREF_NAME = "GOJ_PROFILES";
    private static final String KEY_ACTIVE = "active_profile";

    public static void saveProfile(Context context, Profile profile) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        try {
            JSONObject json = new JSONObject();
            json.put("name", profile.name);
            json.put("proxy", profile.proxy);
            json.put("deviceModel", profile.deviceModel);
            json.put("userAgent", profile.userAgent);
            json.put("timezone", profile.timezone);
            json.put("latitude", profile.latitude);
            json.put("longitude", profile.longitude);
            json.put("locale", profile.locale);
            prefs.edit().putString(profile.name, json.toString()).apply();
            prefs.edit().putString(KEY_ACTIVE, profile.name).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Profile getActiveProfile(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String activeName = prefs.getString(KEY_ACTIVE, "default");
        String jsonStr = prefs.getString(activeName, null);
        
        Profile profile = new Profile();
        if (jsonStr != null) {
            try {
                JSONObject json = new JSONObject(jsonStr);
                profile.name = json.optString("name", "default");
                profile.proxy = json.optString("proxy", "");
                profile.deviceModel = json.optString("deviceModel", "");
                profile.userAgent = json.optString("userAgent", "");
                profile.timezone = json.optString("timezone", "America/New_York");
                profile.latitude = json.optDouble("latitude", 40.7128);
                profile.longitude = json.optDouble("longitude", -74.0060);
                profile.locale = json.optString("locale", "en-US");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return profile;
    }

    public static void setActiveProfile(Context context, String name) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_ACTIVE, name).apply();
    }
}