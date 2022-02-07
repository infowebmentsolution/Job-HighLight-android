package com.infowebmentsolution.jobhighlight;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;


import android.graphics.Typeface;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public class AboutUsActivity extends AppCompatActivity {
    public static String active = "false";
    String error;


    String jhl1;
    String jhl2;
    String jhlAbout;
    public AdView mAdView;
    public InterstitialAd mInterstitialAd;
    private WebView mWebView;
    TextView adText;
    Intent rateapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        active = "true";

        this.error = getString(R.string.open_error_text);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        final WebView webView = (WebView) findViewById(R.id.web_aboutus);
        this.mWebView = (WebView) findViewById(R.id.web_aboutus);
        if (Build.VERSION.SDK_INT >= 19) {
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setHomeAsUpIndicator(R.drawable.ic_back);
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setElevation(0.0f);
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setDisplayHomeAsUpEnabled(true);
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getString(R.string.app_name));
            supportActionBar.setSubtitle(getString(R.string.OJN));
            setTitle(R.string.OJN);
        }
        MobileAds.initialize((Context) this, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        new AdView(this).setAdUnitId(getString(R.string.app_adcode_id));
        this.mAdView = (AdView) findViewById(R.id.adView_aboutus);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.mAdView.setAdListener(new AdListener() {
            public void onAdClosed() {
                AboutUsActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                AboutUsActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }
        });
        com.google.android.gms.ads.InterstitialAd interstitialAd = new com.google.android.gms.ads.InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(getString(R.string.app_adunit));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                AboutUsActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                AboutUsActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
;
        this.jhlAbout = "https://jobhighlight.com/user/about";


        this.jhl1 = "https://jobhighlight.com/user";
        this.jhl2 = "https://jobhighlight.com/user/forgot_password";

        webView.setVerticalScrollBarEnabled(false);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setLongClickable(true);

        webView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

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
                ((AudioManager) AboutUsActivity.this.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(5);

                if (url.equals(AboutUsActivity.this.jhlAbout)) {
                    return false;
                }else if( url.startsWith(AboutUsActivity.this.jhl2)) {
                    Intent intent2 = new Intent(AboutUsActivity.this, CLinkActivity.class);
                    intent2.putExtra("passu", url);
                    AboutUsActivity.this.startActivity(intent2);
                    return true;
                }  else if(url.equals(AboutUsActivity.this.jhl1)){
                    Intent intent1 = new Intent(AboutUsActivity.this, MainActivity.class);
                    intent1.putExtra("passu", url);
                    AboutUsActivity.this.startActivity(intent1);
                    return  true;

                }
                else {

                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                AlertDialog create = new AlertDialog.Builder(AboutUsActivity.this).create();
                try {
                    webView.stopLoading();
                } catch (Exception unused) {
                }
                if (webView.canGoBack()) {
                    webView.goBack();
                }
                webView.loadUrl("about:blank");
                create.setCancelable(false);
                create.setIcon((int) R.drawable.notify_icon_large);
                create.setCanceledOnTouchOutside(false);
                create.setTitle(Html.fromHtml("<font color='#e65100'>No Internet</font>"));
                create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                create.setButton(-2, (CharSequence) "Try Again", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AboutUsActivity.this.startActivity(AboutUsActivity.this.getIntent());
                    }
                });
                create.setButton(-1, (CharSequence) "Exit", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AboutUsActivity.this.finishAffinity();
                        System.exit(0);
                    }
                });
                create.show();
                Typeface createFromAsset = Typeface.createFromAsset(AboutUsActivity.this.getAssets(), "lib/assets/font/ArchivoBlack-Regular.ttf");
                //  ((TextView) create.findViewById(16908299)).setTypeface(createFromAsset);
              //  ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
                Button button = create.getButton(-2);
                if (button != null) {
                    button.setTextColor(AboutUsActivity.this.getResources().getColor(R.color.colorPrimary));
                }
                super.onReceivedError(webView, i, str, str2);
            }

        });
        webView.loadUrl(this.jhlAbout);
        Log.d("hmlk", this.jhlAbout);
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

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}