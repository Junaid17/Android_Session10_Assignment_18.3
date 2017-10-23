package com.example.jmush.android_session18_assignment_181;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intialising context
        mContext=this;
//        Intialising Button
        Button button= (Button) findViewById(R.id.button);
//        onClick of button get notification
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                int icon = R.mipmap.ic_launcher;

                int mNotificationId = 001;

                PendingIntent resultPendingIntent =
                        PendingIntent.getActivity(
                                mContext,
                                0,
                                intent,
                                PendingIntent.FLAG_CANCEL_CURRENT
                        );

                String message= "Hi\nHow are you\nHow are you doing today\n My Name is Junaid\nAndroid_Assignment_18.3";

//                Creating Notification builder yo set title, ringtone, and displaying the message

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                        mContext);
                Notification notification = mBuilder.setSmallIcon(icon).setTicker("SMS NOTIFICATION").setWhen(0)
                        .setAutoCancel(true)
                        .setContentTitle("SMS NOTIFICATION")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                        .setContentIntent(resultPendingIntent)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher))
                        .setContentText(message).build();

                NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(mNotificationId, notification);
            }
        });
    }
}
