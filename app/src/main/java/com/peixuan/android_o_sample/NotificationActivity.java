package com.peixuan.android_o_sample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        setNotificationChannel();
    }

    private void setNotificationChannel() {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String id = "my_channel_01";

        CharSequence name = "channel_name";

        int importance = NotificationManager.IMPORTANCE_LOW;

        //only compile in android-o
        NotificationChannel mChannel = new NotificationChannel(id, name, importance);
        mChannel.enableLights(true);
        mChannel.setLightColor(Color.RED);
        mChannel.enableVibration(true);
        mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        notificationManager.createNotificationChannel(mChannel);

        
        Notification notification = new Notification.Builder(NotificationActivity.this
        ).setContentTitle("New Message")
                .setContentText("You've received new messages.")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setChannel(id)
                .build();
        notificationManager.notify(1, notification);
    }
}
