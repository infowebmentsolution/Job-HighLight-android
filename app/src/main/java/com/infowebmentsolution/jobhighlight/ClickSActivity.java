package com.infowebmentsolution.jobhighlight;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
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
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

public class ClickSActivity extends AppCompatActivity {


    String docs_forms;
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
    String play_store;
    String tlg;
    String wap;
    String YT;
    String amz;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private WebView mWebView2;
    private ProgressBar progressBar;
    Intent rateapp;
    String url;
    String wait_approval;


    @Override
    public void onCreate(Bundle bundle) {

        this.wait_approval = getString(R.string.navigation_drawer_approval);
        super.onCreate(bundle);
        setContentView(R.layout.activity_slnk);

        if (Build.VERSION.SDK_INT >= 19) {
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setHomeAsUpIndicator(R.drawable.ic_back);
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setElevation(0.0f);
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setDisplayHomeAsUpEnabled(true);
        }


        final WebView webView = (WebView) findViewById(R.id.webView2);

        this.mWebView2 = (WebView) findViewById(R.id.webView2);
        if (!CheckConnectionActivity.checkInternetConnection(this)) {
            try {
                webView.stopLoading();
                webView.loadUrl("about:blank");
                AlertDialog create = new AlertDialog.Builder(this).create();
                create.setCancelable(false);
                create.setIcon(R.drawable.notify_icon_large);
                create.setCanceledOnTouchOutside(false);
                create.setTitle(Html.fromHtml("<font color='#FF6F00'>No Internet !</font>"));
                create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                create.setButton(-2, "Try Again", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            ClickSActivity.this.recreate();
                            return;
                        }
                        Intent intent = ClickSActivity.this.getIntent();
                        ClickSActivity.this.finish();
                        ClickSActivity.this.startActivity(intent);
                    }
                });
                create.setButton(-1, "Back", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialogInterface, int i) {
                        ClickSActivity.this.finish();
                    }
                });
                if (Build.VERSION.SDK_INT >= 19) {
                    ((Window) Objects.requireNonNull(create.getWindow())).getAttributes().windowAnimations = R.style.DialogTheme1;
                }
                create.show();
                Button button = create.getButton(-2);
                if (button != null) {
                    button.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
              //  ((TextView) create.findViewById(16908299)).setTypeface(createFromAsset);
                ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
            } catch (Exception unused) {
            }
            if (webView.canGoBack()) {
                webView.goBack();
                return;
            }
            return;
        }
        this.jhlHome= "https://jobhighlight.com/";
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
        this.docs_forms = "https://docs.google.com/forms/";
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            /* class com.jobhighlight.apps.ClickSActivity.AnonymousClass3 */

            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        new AdView(this).setAdUnitId(getString(R.string.app_adcode_id));
        this.mAdView = (AdView) findViewById(R.id.adView3);

        //========================================================offstart
       this.mAdView.loadAd(new AdRequest.Builder().build());
        this.mAdView.setAdListener(new AdListener() {

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                ClickSActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ClickSActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }
        });

        //===============================================================finished

        InterstitialAd interstitialAd = new InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(getString(R.string.app_adunit));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener() {
            /* class com.jobhighlight.apps.ClickSActivity.AnonymousClass5 */

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                ClickSActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ClickSActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.progressBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.primaryYlw)));
        }
        this.progressBar.setMax(100);
        this.url = getIntent().getStringExtra("passu");
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


            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                String str2;
                try {
                    str2 = new URL(url).getPath();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    str2 = "";
                }
                ((AudioManager) ClickSActivity.this.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(5);

                if (url.equals(ClickSActivity.this.jhlHome)) {
                    return false;
                }


                if (url.toLowerCase().endsWith(".pdf")) {
                    Intent intent2 = new Intent(ClickSActivity.this, ExamLinkActivity.class);
                    intent2.putExtra("passu", url);
                    ClickSActivity.this.startActivity(intent2);
                    return true;
                } else if (url.toLowerCase().startsWith(ClickSActivity.this.amz) || url.toLowerCase().startsWith(ClickSActivity.this.flk)
                        ||((url.startsWith(ClickSActivity.this.jhl1) || url.startsWith(ClickSActivity.this.jhl2)) && url.toLowerCase().endsWith("affiliate/"))) {
                    Intent intent3 = new Intent(ClickSActivity.this, EWActivity.class);
                    intent3.putExtra("passu", url);
                    ClickSActivity.this.startActivity(intent3);
                    return true;
                } else if (url.startsWith(ClickSActivity.this.play_store) || url.startsWith(ClickSActivity.this.YT) ||
                        url.startsWith(ClickSActivity.this.wap) ||url.startsWith(ClickSActivity.this.f_b) ||
                        url.startsWith(ClickSActivity.this.e_mail) || url.startsWith(ClickSActivity.this.tlg)) {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                }
                else if (url.startsWith(ClickSActivity.this.jhl1) || url.startsWith(ClickSActivity.this.jhl2) ||
                        url.startsWith(ClickSActivity.this.jhl3) || url.startsWith(ClickSActivity.this.jhl4) ||
                        url.startsWith(ClickSActivity.this.jhl5) || url.startsWith(ClickSActivity.this.jhl6) ||
                        url.startsWith(ClickSActivity.this.jhl7) || url.startsWith(ClickSActivity.this.jhl8) ||
                        url.startsWith(ClickSActivity.this.jhl9) || url.startsWith(ClickSActivity.this.jhl10) ||
                        url.startsWith(ClickSActivity.this.jhl11) || url.startsWith(ClickSActivity.this.jhl12)) {
                    Intent intent4 = new Intent(ClickSActivity.this, CLinkActivity.class);
                    intent4.putExtra("passu", url);
                    ClickSActivity.this.startActivity(intent4);
                    return true;
                }
                else {

                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                ClickSActivity.this.progressBar.setVisibility(View.GONE);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                try {
                    webView.stopLoading();
                    webView.loadUrl("about:blank");
                    AlertDialog create = new AlertDialog.Builder(ClickSActivity.this).create();
                    webView.loadUrl("about:blank");
                    create.setCancelable(false);
                    create.setIcon(R.drawable.notify_icon_large);
                    create.setCanceledOnTouchOutside(false);
                    create.setTitle(Html.fromHtml("<font color='#FF6F00'>No Internet !</font>"));
                    create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                    create.setButton(-2, "Try Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (Build.VERSION.SDK_INT >= 17) {
                                ClickSActivity.this.recreate();
                                return;
                            }
                            Intent intent = ClickSActivity.this.getIntent();
                            ClickSActivity.this.finish();
                            ClickSActivity.this.startActivity(intent);
                        }
                    });
                    create.setButton(-1, "Back", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialogInterface, int i) {
                            ClickSActivity.this.finish();
                        }
                    });
                    if (Build.VERSION.SDK_INT >= 19) {
                        ((Window) Objects.requireNonNull(create.getWindow())).getAttributes().windowAnimations = R.style.DialogTheme1;
                    }
                    create.show();
                    Button button = create.getButton(-2);
                    if (button != null) {
                        button.setTextColor(ClickSActivity.this.getResources().getColor(R.color.colorPrimary));
                    }
                    Typeface createFromAsset = Typeface.createFromAsset(ClickSActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
                    ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
                } catch (Exception unused) {
                }
                if (webView.canGoBack()) {
                    webView.goBack();
                }
                super.onReceivedError(webView, i, str, str2);
            }
        });
        webView.loadUrl(this.url);
        this.progressBar.setProgress(0);
        this.mWebView2.setWebChromeClient(new WebChromeClient());
        this.mWebView2.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                ClickSActivity.this.progressBar.setProgress(i);
                ActionBar supportActionBar = ClickSActivity.this.getSupportActionBar();
                super.onProgressChanged(webView, i);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hdr_right, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.reload_r:
                mWebView2.reload();

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

    public void onBackPressed() {
        if (this.mWebView2.canGoBack()) {
            this.mWebView2.goBack();
        } else {
            finish();
        }
    }
}