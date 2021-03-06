package com.demo.locationtracker;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.demo.locationtracker.MyApp.CHANNEL_ID;

public class LocationService extends Service {
    public static final String NOTIFICATION = "com.demo.locationtracker";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Location Service")
                .setContentText("here is your location")
                .setSmallIcon(R.drawable.ic_location)
                .setContentIntent(pendingIntent)
                .setTicker(getText(R.string.gret_notification))
                .build();

        startForeground(1, notification);


        return START_STICKY;
    }



    private void publishLocation(MyApp.Location location){
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra("latitude", location.getLatitude());
        intent.putExtra("longitude", location.getLongitude());
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
