package com.infowebmentsolution.jobhighlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Bundle;

public class SplashscreenActivity extends AppCompatActivity {
    String urlMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
       // LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,new IntentFilter("com.infowebmentsolution.jobhighlight_FCM_MESSAGE"));
        if(getIntent().getExtras() != null){
            for(String key : getIntent().getExtras().keySet()){
                if (key.equals("urlmsg")){

                    urlMessage=getIntent().getExtras().getString(key);
                    System.out.println("------------------------------------------------"+getIntent().getExtras().getString(key));
                }
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashscreenActivity.this, RNewActivity.class);
                    intent.putExtra("urlMessage", urlMessage);
                    startActivity(intent);
                    finish();
                }
            }, 1000);
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);

                    startActivity(intent);
                    finish();
                }
            }, 1000);
        }
    }
}