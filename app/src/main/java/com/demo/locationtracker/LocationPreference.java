package com.demo.locationtracker;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class LocationPreference {
    private static final String SETTINGS_NAME = "location_settings";
    private static final String LIST_NAME = "location_list";
    private static LocationPreference locationPreference = new LocationPreference();
    private static SharedPreferences mPref;
    private static SharedPreferences.Editor editor;

    private LocationPreference() {}

    public static LocationPreference getInstance(Context context){
        if (mPref == null) {
            mPref = context.getSharedPreferences(SETTINGS_NAME, context.MODE_PRIVATE );
            editor = mPref.edit();
        }
        return locationPreference;
    }

    public void clearAll(){
        editor.clear();
        editor.apply();
    }

    public void saveList(List<MyApp.Location> locationList){
        String locationJSONList = new Gson().toJson(locationList);
        editor.putString(LIST_NAME, locationJSONList);
        editor.apply();
    }

    public List<MyApp.Location> getList(){
        String locationJSONList = mPref.getString(LIST_NAME, null);
        List<MyApp.Location> locationList =
                new Gson().fromJson(locationJSONList, new TypeToken<List<MyApp.Location>>(){}.getType());
        return locationList;
    }


}
