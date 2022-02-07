package com.infowebmentsolution.jobhighlight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SwipeRefreshLayout.OnRefreshListener {

    public static String active = "false";
    boolean doubleBackToExitPressedOnce = false;
    String e_mail;
    String f_b;
    String flk;
    String jhl1;
    String jhl2;
    String jhl3;
    String jhl4;
    String jhl5;
    String jhl6;
    String jhl7;
    String jhl8;
    String jhl9;
    String jhl10;
    String jhl11;
    String jhl12;
    String jhlHome;
    String jhlHome1;
    String play_store;
    String tlg;
    String wap;
    String YT;
    String amz;

    public AdView mAdView;
    public InterstitialAd mInterstitialAd;
    private WebView mWebView;

    Intent rateapp;
    public SwipeRefreshLayout swipeRefreshLayout;


    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mWebView.saveState(bundle);
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        this.swipeRefreshLayout = swipeRefreshLayout2;
        swipeRefreshLayout2.setOnRefreshListener(this);
        this.swipeRefreshLayout.setRefreshing(false);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mWebView.restoreState(bundle);
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        this.swipeRefreshLayout = swipeRefreshLayout2;
        swipeRefreshLayout2.setOnRefreshListener(this);
        this.swipeRefreshLayout.setRefreshing(false);
    }

    @SuppressLint({"ResourceAsColor", "MissingPermission"})
    public void onCreate(Bundle bundle) {
        active = "true";
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        final WebView webView = (WebView) findViewById(R.id.webView);
        this.mWebView = (WebView) findViewById(R.id.webView);

        MobileAds.initialize((Context) this, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        new AdView(this).setAdUnitId(getString(R.string.app_adcode_id));
        this.mAdView = (AdView) findViewById(R.id.adView);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.mAdView.setAdListener(new AdListener() {
            public void onAdClosed() {
                MainActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                MainActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }
        });
        InterstitialAd interstitialAd = new InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(getString(R.string.app_adunit));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                MainActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                MainActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
             setSupportActionBar(toolbar);
              getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setSubtitle((CharSequence) "Online Job News");

        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        this.swipeRefreshLayout = swipeRefreshLayout2;
        swipeRefreshLayout2.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeColors(Color.rgb(255, 28, 0), Color.rgb(57, 82, 96), Color.rgb(76, 175, 80), Color.rgb(255, 170, 6));
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.container);

        this.jhlHome= "https://jobhighlight.com/";
        this.jhlHome1="https://jobhighlight.com/user";
        this.jhl1 = "https://jobhighlight.com/user/";
        this.jhl2="https://jobhighlight.com/user/letestjob";
        this.jhl3="https://jobhighlight.com/user/all_favourites";
        this.jhl4="https://jobhighlight.com/user/last_date_job";
        this.jhl5="https://jobhighlight.com/user/all_admit_card";
        this.jhl6="https://jobhighlight.com/user/syllabus_list";
        this.jhl7="https://jobhighlight.com/user/all_result";
        this.jhl8="https://jobhighlight.com/user/examinationdate";
        this.jhl9 ="https://jobhighlight.com/user/notification";
        this.jhl10="https://jobhighlight.com/user/all_current_affairs";
        this.jhl11="https://jobhighlight.com/user/general";
        this.jhl12="https://jobhighlight.com/user/qustion";
      
        this.play_store = "https://play.google.com";
        this.YT = "https://www.youtube.com";
        this.wap = "whatsapp";
        this.f_b = "fb:";
        this.e_mail = "mailto";
        this.tlg = "https://t.me/";
        this.amz = "https://www.amazon.";
        this.flk = "https://www.flipkart.";

        webView.setVerticalScrollBarEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setLongClickable(true);

        webView.setOnLongClickListener(view -> true);

      //  webView.getSettings().setBuiltInZoomControls(true);
      //  webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient() {

            {
                Class<MainActivity> cls = MainActivity.class;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                String str2;
                try {
                    str2 = new URL(url).getPath();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    str2 = "";
                }
                  ((AudioManager) MainActivity.this.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(5);

                if (url.equals(MainActivity.this.jhlHome) || url.equals(MainActivity.this.jhlHome1)) {
                    return false;
                }

            if (url.toLowerCase().endsWith(".pdf")) {
                    Intent intent2 = new Intent(MainActivity.this, ExamLinkActivity.class);
                    intent2.putExtra("passu", url);
                    MainActivity.this.startActivity(intent2);
                    System.out.println("--------------------------------------------------------------1");
                    return true;
                } else if (url.toLowerCase().startsWith(MainActivity.this.amz) || url.toLowerCase().startsWith(MainActivity.this.flk) ||
                        ((url.startsWith(MainActivity.this.jhl1) || url.startsWith(MainActivity.this.jhl2)) && url.toLowerCase().endsWith("affiliate/"))) {
                    Intent intent3 = new Intent(MainActivity.this, EWActivity.class);
                    intent3.putExtra("passu", url);
                    MainActivity.this.startActivity(intent3);
                System.out.println("--------------------------------------------------------------2");
                    return true;
                } else if (url.startsWith(MainActivity.this.play_store) || url.startsWith(MainActivity.this.YT) || url.startsWith(MainActivity.this.wap) ||
                        url.startsWith(MainActivity.this.f_b) || url.startsWith(MainActivity.this.e_mail) || url.startsWith(MainActivity.this.tlg)) {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                System.out.println("--------------------------------------------------------------3");
                    return true;
                }
                else if (url.startsWith(MainActivity.this.jhl1) || url.startsWith(MainActivity.this.jhl2) || url.startsWith(MainActivity.this.jhl3) || url.startsWith(MainActivity.this.jhl4) || url.startsWith(MainActivity.this.jhl5) || url.startsWith(MainActivity.this.jhl6) || url.startsWith(MainActivity.this.jhl7) || url.startsWith(MainActivity.this.jhl8) || url.startsWith(MainActivity.this.jhl9) || url.startsWith(MainActivity.this.jhl10) || url.startsWith(MainActivity.this.jhl11) || url.startsWith(MainActivity.this.jhl12)) {
                    Intent intent4 = new Intent(MainActivity.this, CLinkActivity.class);
                    intent4.putExtra("passu", url);
                    MainActivity.this.startActivity(intent4);
                System.out.println("--------------------------------------------------------------4");
                    return true;
                }
                else {

                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                System.out.println("--------------------------------------------------------------5");
                    return true;
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                AlertDialog create = new AlertDialog.Builder(MainActivity.this).create();
                try {
                    webView.stopLoading();
                } catch (Exception e) {
                }
                if (webView.canGoBack()) {
                    webView.goBack();
                }
                webView.loadUrl("about:blank");
                create.setCancelable(false);
                create.setIcon(R.drawable.notify_icon_large);
                create.setCanceledOnTouchOutside(false);
                create.setTitle(Html.fromHtml("<font color='#e65100'>No Internet</font>"));
                create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                create.setButton(-2, (CharSequence) "Try Again", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.startActivity(MainActivity.this.getIntent());
                    }
                });
                create.setButton(-1, (CharSequence) "Exit", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finishAffinity();
                        System.exit(0);
                    }
                });
                create.show();
                ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf"));
                Button button = create.getButton(-2);
                if (button != null) {
                    button.setTextColor(MainActivity.this.getResources().getColor(R.color.colorPrimary));
                }
                super.onReceivedError(webView, i, str, str2);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                MainActivity.this.swipeRefreshLayout.setRefreshing(true);
            }

            public void onPageFinished(WebView webView, String str) {
                MainActivity.this.swipeRefreshLayout.setRefreshing(false);
            }
        });
        webView.loadUrl(this.jhlHome);
        Log.d("hmlk", this.jhlHome);
        this.swipeRefreshLayout.setRefreshing(false);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList((ColorStateList) null);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hdr_right, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.reload_r:
                mWebView.reload();
                break;
            case R.id.share_r:
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("text/plain");
                intent2.putExtra("android.intent.extra.SUBJECT", "APP NAME (Open it in Google Play Store to Download the Application)");
                startActivity(Intent.createChooser(intent2, "Share via"));
                break;
            case R.id.privacy_r:
                startActivity(new Intent(this, PrivacyPolicyActivity.class));
                break;
            case R.id.rate_us_r:
                Intent intent = new Intent("android.intent.action.VIEW");
                this.rateapp = intent;
                intent.setData(Uri.parse("market://details?id=" + getPackageName()));
                startActivity(this.rateapp);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.login) {
            startActivity(new Intent(this, SignInActivity.class));
        } else if (itemId == R.id.logout) {
            startActivity(new Intent(this, LogoutActivity.class));
        } else if (itemId == R.id.contact_us) {
            startActivity(new Intent(this, ContactUsActivity.class));
        } else if (itemId == R.id.about) {
            startActivity(new Intent(this, AboutUsActivity.class));
        } else if (itemId == R.id.privacy) {
            startActivity(new Intent(this, PrivacyPolicyActivity.class));
        }
        if (itemId == R.id.rate_us) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.rateapp = intent;
            intent.setData(Uri.parse("market://details?id=" + getPackageName()));
            startActivity(this.rateapp);
        } else if (itemId == R.id.share) {
//            Intent i=new Intent(android.content.Intent.ACTION_SEND);
//            i.setType("text/plain");
//            i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
//            i.putExtra(android.content.Intent.EXTRA_TEXT, "extra text that you want to put");
//            startActivity(Intent.createChooser(i,"Share via"));

            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage= "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch(Exception e) {
                //e.toString();
            }
        }
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer((int) GravityCompat.START);
        return true;
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            drawerLayout.closeDrawer((int) GravityCompat.START);
        } else if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else if (this.doubleBackToExitPressedOnce) {
            super.onBackPressed();
        } else {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MainActivity.this.doubleBackToExitPressedOnce = false;
                }
            }, 2000);
            finishAffinity();
        }
    }

    public void onRefresh() {
        this.mWebView.clearCache(true);
        this.mWebView.reload();
    }

}