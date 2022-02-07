package com.infowebmentsolution.jobhighlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class Welcome extends AppCompatActivity {

    String jhl1;
    String jhl2;
    String jhl3;
    String jhl4;
    String jhl5;
    String jhl6;
    String jhl7;
    String jhl9;
    String jhl11;
    String jhl14;
    String ds_enabled;
    int net_flag;
    String amz;
    String e_mail;
    String f_b;
    String flk;
    String play_store;
    String t_lgrm;
    String url;
    String wht_app;
    String you_tube;
    WebView webView;

    TextView t1 ,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
      //  LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,new IntentFilter("com.infowebmentsolution.jobhighlight_FCM_MESSAGE"));
        webView = (WebView) findViewById(R.id.web_notification);

        this.net_flag = 1;
        this.ds_enabled = "show";
        StringBuilder sb = new StringBuilder();
        this.jhl1 = "https://jobhighlight.com/user";
        this.play_store = "https://play.google.com";
        this.you_tube = "https://www.youtube.com";
        this.wht_app = "whatsapp";
        this.f_b = "fb:";
        this.e_mail = "mailto";
        this.t_lgrm = "t.me/";
        this.amz = "https://www.amazon.";
        this.flk = "https://www.flipkart.";

        t1=findViewById(R.id.firebasetitle);
        t2=findViewById(R.id.firebaseurl);

        if(getIntent().getExtras() != null){
            for(String key : getIntent().getExtras().keySet()){
                if(key.equals("title")){
                    t1.setText(getIntent().getExtras().getString(key));
                }else if (key.equals("urlmsg")){
                    t2.setText(getIntent().getExtras().getString(key));
                    webView.loadUrl("https://google.com");//getIntent().getExtras().getString(key)
                    System.out.println("------------------------------------------------"+getIntent().getExtras().getString(key));
                }
            }
        }
      //  loadPage(getIntent());
    }

    @Override
    protected void onPause() {
        super.onPause();
    //    LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    //    public void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        loadPage(intent);
//    }

    private void loadPage(Intent intent) {
        String intentStringExtra = intent.getStringExtra("data");
        if (intentStringExtra != null) {
            Log.d("NRA8", intentStringExtra);
            Map map = (Map) new Gson().fromJson(intentStringExtra, new HashMap().getClass());

            if(map.containsKey("jobhighlightURL")){
                String str = (String) map.get("url1");
                this.url = str;

                if(url.endsWith(".pdf")){
                    Intent intent2 = new Intent(Welcome.this, ExamLinkActivity.class);
                    intent2.putExtra("passu", url);
                    startActivity(intent2);
                }
                else if(url.startsWith(this.jhl1)){
                    webView.loadUrl(url);
                }
            }
        }
    }
//    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            String title = intent.getStringExtra("title");
//            String msg = intent.getStringExtra("urlmsg");
//            t1.setText(title);
//            t2.setText(msg);
//        }
//    };

    @Override
    public void onBackPressed() {
       startActivity(new Intent(Welcome.this,MainActivity.class));

    }
}