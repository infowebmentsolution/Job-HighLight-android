package com.infowebmentsolution.jobhighlight;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import java.util.Objects;

public class AddNotification extends FirebaseMessagingService {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    static String channelId = "demo";
    static String channelName = "NOTIFICATION_CHANNEL_NAME";

    private void sendRegistrationToServer(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String str = null;
        String title = Build.VERSION.SDK_INT >= 19 ? ((RemoteMessage.Notification) Objects.requireNonNull(remoteMessage.getNotification())).getTitle() : null;
        if (Build.VERSION.SDK_INT >= 19) {
            str = ((RemoteMessage.Notification) Objects.requireNonNull(remoteMessage.getNotification())).getBody();
        }
        Intent intent = new Intent(this, PrivacyPolicyActivity.class);
        if (remoteMessage.getData().size() > 0) {
//            String json = new Gson().toJson((Object) remoteMessage.getData());
//            intent.putExtra("data", json);
//            Log.d("sFM", json);

            String title1 = remoteMessage.getData().get("title");
            String urlMessage = remoteMessage.getData().get("urlmsg");
            Intent intent1=new Intent("com.infowebmentsolution.jobhighlight_FCM_MESSAGE");
            intent1.putExtra("title",title1);
            intent1.putExtra("urlmsg",urlMessage);
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            localBroadcastManager.sendBroadcast(intent1);
        }

//        startActivity(intent);
//        createNotification(this, intent, title, str);
    }

    public void createNotification(Context context, Intent intent, String str, String str2) {
        System.out.println("---------------------->"+str);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        SharedPreferences sharedPreferences = context.getSharedPreferences("appPref", 0);
        int i = sharedPreferences.getInt("notificationNumber", 1);
        PendingIntent activity = PendingIntent.getActivity(context, i, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.notify_icon_small).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.notify_icon_large)).setDefaults(1).setContentIntent(activity).setColor(context.getResources().getColor(R.color.colorPrimary)).setContentTitle(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str2)).setContentText(str2).setAutoCancel(true).setDefaults(1).setContentIntent(activity);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            contentIntent.setChannelId(channelId);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(i, contentIntent.build());
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("notificationNumber", i + 1);
        edit.apply();
    }

//    static final /* synthetic */ boolean $assertionsDisabled = false;
//    static String channelId = "demo";
//    static String channelName = "NOTIFICATION_CHANNEL_NAME";
//    private void sendRegistrationToServer(String str) {
//    }
//
//    public void onNewToken(String str) {
//    }
//
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
//        String str = null;
//        String title = Build.VERSION.SDK_INT >= 19 ? ((RemoteMessage.Notification) Objects.requireNonNull(remoteMessage.getNotification())).getTitle() : null;
//        if (Build.VERSION.SDK_INT >= 19) {
//            str = ((RemoteMessage.Notification) Objects.requireNonNull(remoteMessage.getNotification())).getBody();
//        }
//        Intent intent = new Intent(this,Welcome.class);
//        if (remoteMessage.getData().size() > 0) {
//            String json = new Gson().toJson((Object) remoteMessage.getData());
//            intent.putExtra("data", json);
//            Log.d("sFM", json);
//        }
//        createNotification(this, intent, title, str);
//    }
//
//    public void createNotification(Context context, Intent intent, String str, String str2) {
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        SharedPreferences sharedPreferences = context.getSharedPreferences("appPref", 0);
//        int i = sharedPreferences.getInt("notificationNumber", 1);
//        PendingIntent activity = PendingIntent.getActivity(context, i, intent, PendingIntent.FLAG_ONE_SHOT);
//        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.notify_icon_small)
//                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.notify_icon_large))
//                .setDefaults(1)
//                .setContentIntent(activity)
//                .setColor(context.getResources()
//                        .getColor(R.color.colorPrimary))
//                .setContentTitle(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str2))
//                .setContentText(str2).setAutoCancel(true)
//                .setDefaults(1)
//                .setContentIntent(activity);
//        if (Build.VERSION.SDK_INT >= 26) {
//            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
//            notificationChannel.enableLights(true);
//            notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
//            notificationChannel.enableVibration(true);
//            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
//            contentIntent.setChannelId(channelId);
//            notificationManager.createNotificationChannel(notificationChannel);
//        }
//        notificationManager.notify(i, contentIntent.build());
//        SharedPreferences.Editor edit = sharedPreferences.edit();
//        edit.putInt("notificationNumber", i + 1);
//        edit.apply();
//    }
}