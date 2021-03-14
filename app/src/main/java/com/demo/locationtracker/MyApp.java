package com.demo.locationtracker;

import android.app.Application;

public class MyApp extends Application {
    public LocationPreference locationPreference;

    @Override
    public void onCreate() {
        super.onCreate();
        locationPreference = LocationPreference.getInstance(getApplicationContext());
    }

     class Location {
        private Double latitude = 0d;
        private Double longitude = 0d;

        public Double getLatitude() {
            return latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
    }
}
