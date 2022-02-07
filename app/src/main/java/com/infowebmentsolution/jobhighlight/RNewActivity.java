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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class RNewActivity extends AppCompatActivity {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    String amazon;
    String com1;
    String com2;
    String com3;
    String com4;
    String com5;
    String com6;
    int countM = 0;
    String docs_forms;
    String e_mail;
    String error;
    String facebook;
    String flipkart;
    String google1;
    String google2;
    String google3;
    String google4;
    String google5;
    String google6;
    String images;
    String jobhighlight_1;
    String jobhighlight_1_s;
    String jobhighlight_2;
    String jobhighlight_2_s;
    String jobhighlight_3;
    String jobhighlight_3_s;
    String jobhighlight_4;
    String jobhighlight_4_s;
    String jobhighlight_5;
    String jobhighlight_5_s;
    String jobhighlight_6;
    String jobhighlight_6_s;
    String jobhighlight_online;
    String jobhighlight_online_s;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    String play_store;
    private ProgressBar progressBar;
    String tel;
    int triggerMaps = 2;
    String url;
    WebView webView;
    String wap;
    String yt;
    Intent rateapp;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        this.google1 = getString(R.string.searching_in);
        this.google2 = getString(R.string.searching_out);
        this.google3 = getString(R.string.search_tag_1);
        this.google4 = getString(R.string.search_tag_2);
        this.google5 = getString(R.string.search_tag_gk);
        this.google6 = getString(R.string.search_tag_mcq);
        this.com1 = getString(R.string.navigation_drawer_open_flag);
        this.com2 = getString(R.string.navigation_drawer_open_flag_command);
        this.com3 = getString(R.string.navigation_drawer_open_flag1);
        this.com4 = getString(R.string.navigation_drawer_open_flag2);
        this.com5 = getString(R.string.navigation_drawer_open_flag_gk);
        this.com6 = getString(R.string.navigation_drawer_open_flag_mcq);
        super.onCreate(bundle);
        setContentView(R.layout.activity_slnk);
        this.webView = (WebView) findViewById(R.id.webView2);

        if (Build.VERSION.SDK_INT >= 19) {
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setHomeAsUpIndicator(R.drawable.ic_back);
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setElevation(0.0f);
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setDisplayHomeAsUpEnabled(true);
            ActionBar supportActionBar = RNewActivity.this.getSupportActionBar();
            supportActionBar.setTitle(RNewActivity.this.getString(R.string.OJN));
            supportActionBar.setSubtitle(RNewActivity.this.getTitle());
            RNewActivity.this.setTitle(R.string.OJN);
        }


        if (!CheckConnectionActivity.checkInternetConnection(this)) {
            try {
                this.webView.stopLoading();
                this.webView.loadUrl("about:blank");
                AlertDialog create = new AlertDialog.Builder(this).create();
                create.setCancelable(false);
                create.setIcon(R.drawable.notify_icon_large);
                create.setCanceledOnTouchOutside(false);
                create.setTitle(Html.fromHtml("<font color='#dea80e'>No Internet !</font>"));
                create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                create.setButton(-2, Html.fromHtml("<font color='#10195d'>Try Again</font>"), new DialogInterface.OnClickListener() {
                    /* class com.jobhighlight.apps.RNewActivity.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            RNewActivity.this.recreate();
                            return;
                        }
                        Intent intent = RNewActivity.this.getIntent();
                        RNewActivity.this.finish();
                        RNewActivity.this.startActivity(intent);
                    }
                });
                create.setButton(-1, "Back", new DialogInterface.OnClickListener() {
                    /* class com.jobhighlight.apps.RNewActivity.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        RNewActivity.this.finish();
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
                Typeface createFromAsset = Typeface.createFromAsset(RNewActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
                //  ((TextView) create.findViewById(16908299)).setTypeface(createFromAsset);
                ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
            } catch (Exception unused) {
            }
            if (this.webView.canGoBack()) {
                this.webView.goBack();
                return;
            }
            return;
        }//END OF CONNECTIVITY CHECKING)



        this.jobhighlight_1 = "https://jobhighlight.com/user";//("https://" + this.google1 + "." + this.com1 + "/").toLowerCase();
        this.jobhighlight_2 ="https://jobhighlight.com/all-job"; //("https://" + this.google2 + "." + this.com2 + "/").toLowerCase();
        this.jobhighlight_3 ="https://jobhighlight.com/all-current-affairs"; //("https://" + this.google3 + "." + this.com3 + "/").toLowerCase();
        this.jobhighlight_4 ="https://jobhighlight.com/all_admit_card";// ("https://" + this.google4 + "." + this.com4 + "/").toLowerCase();
        this.jobhighlight_5 ="https://jobhighlight.com/syllabus-list";//("https://" + this.google5 + "." + this.com5 + "/").toLowerCase();
        this.jobhighlight_6 = "https://jobhighlight.com/all-result";  //("https://" + this.google6 + "." + this.com6 + "/").toLowerCase();
        this.jobhighlight_1_s = "https://jobhighlight.com/user/admit_details/";//("https://" + this.google1 + "." + this.com1 + "/").toLowerCase();
        this.jobhighlight_2_s ="https://jobhighlight.com/admit_details";// ("https://" + this.google2 + "." + this.com2 + "/").toLowerCase();
        this.jobhighlight_3_s ="https://jobhighlight.com/upload_file/Admit/";// ("https://" + this.google3 + "." + this.com3 + "/").toLowerCase();
        this.jobhighlight_4_s = ("https://" + this.google4 + "." + this.com4 + "/").toLowerCase();
        this.jobhighlight_5_s = ("https://" + this.google5 + "." + this.com5 + "/").toLowerCase();
        this.jobhighlight_6_s = ("https://" + this.google6 + "." + this.com6 + "/").toLowerCase();
        this.play_store = "https://play.google.com";
        this.yt = "https://www.youtube.com";
        this.wap = "whatsapp";
        this.facebook = "fb:";
        this.e_mail = "mailto";
        this.tel = "https://t.me/";
        this.amazon = "https://www.amazon.";
        this.flipkart = "https://www.flipkart.";
        this.docs_forms = "https://docs.google.com/forms/";

        // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
        MobileAds.initialize(this, initializationStatus -> {
        });
        new AdView(this).setAdUnitId(getString(R.string.app_adcode_id));
        this.mAdView = (AdView) findViewById(R.id.adView2);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.mAdView.setAdListener(new AdListener() {


            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                RNewActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                RNewActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }
        });
        InterstitialAd interstitialAd = new InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(getString(R.string.app_adunit));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener() {
            /* class com.jobhighlight.apps.RNewActivity.AnonymousClass5 */

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                RNewActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                RNewActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.progressBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.primaryYlw)));
        }
        this.progressBar.setMax(100);
        loadPage(getIntent());
    }




    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        loadPage(intent);
    }

    /* access modifiers changed from: package-private */
    public void loadPage(Intent intent) {
        this.url = intent.getStringExtra("urlMessage");
        this.webView.setVerticalScrollBarEnabled(false);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        this.webView.setLongClickable(true);
        this.webView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.jobhighlight.apps.RNewActivity.AnonymousClass6 */

            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setDisplayZoomControls(false);
        this.webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);

        this.webView.setWebViewClient(new WebViewClient() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String str2;
                try {
                    str2 = new URL(str).getPath();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    str2 = "";
                }
                ((AudioManager) RNewActivity.this.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(0);
                if(str.equals(RNewActivity.this.jobhighlight_1)){
                    Intent intentM = new Intent(RNewActivity.this, MainActivity.class);
                    RNewActivity.this.startActivity(intentM);
                    // return true;
                }
                else if (str.toLowerCase().startsWith(RNewActivity.this.amazon) || str.toLowerCase().startsWith(RNewActivity.this.flipkart) || ((str.startsWith(RNewActivity.this.jobhighlight_1) || str.startsWith(RNewActivity.this.jobhighlight_1_s)) && str.toLowerCase().endsWith("affiliate/"))) {
                    Intent intent = new Intent(RNewActivity.this, EWActivity.class);
                    intent.putExtra("passu", str);
                    RNewActivity.this.startActivity(intent);
                } else if (str.toLowerCase().startsWith(RNewActivity.this.docs_forms)) {
                    if (RNewActivity.this.mInterstitialAd.isLoaded()) {
                        RNewActivity.this.mInterstitialAd.show();
                        RNewActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                    Intent intent2 = new Intent(RNewActivity.this, ExamLinkActivity.class);
                    intent2.putExtra("passu", str);
                    RNewActivity.this.startActivity(intent2);
                    return true;
                } else if (str.startsWith(RNewActivity.this.play_store) || str.startsWith(RNewActivity.this.yt) || str.startsWith(RNewActivity.this.wap) || str.startsWith(RNewActivity.this.facebook) || str.startsWith(RNewActivity.this.e_mail) || str.startsWith(RNewActivity.this.tel)) {
                    RNewActivity.this.webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } else if ((str.startsWith(RNewActivity.this.jobhighlight_1) || str.startsWith(RNewActivity.this.jobhighlight_1_s) || str.startsWith(RNewActivity.this.jobhighlight_2) || str.startsWith(RNewActivity.this.jobhighlight_2_s) || str.startsWith(RNewActivity.this.jobhighlight_3) || str.equals(RNewActivity.this.jobhighlight_3_s) || str.startsWith(RNewActivity.this.jobhighlight_4) || str.startsWith(RNewActivity.this.jobhighlight_4_s) || str.startsWith(RNewActivity.this.jobhighlight_5) || str.startsWith(RNewActivity.this.jobhighlight_5_s) || str.startsWith(RNewActivity.this.jobhighlight_6) || str.startsWith(RNewActivity.this.jobhighlight_6_s)) && str2.startsWith("/subject")) {
                    if (RNewActivity.this.mInterstitialAd.isLoaded()) {
                        RNewActivity.this.mInterstitialAd.show();
                        RNewActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                    Intent intent3 = new Intent(RNewActivity.this, ExamLinkMainActivity.class);
                    intent3.putExtra("passu", str);
                    RNewActivity.this.startActivity(intent3);
                } else if (str.startsWith(RNewActivity.this.jobhighlight_1) || str.startsWith(RNewActivity.this.jobhighlight_1_s) || str.startsWith(RNewActivity.this.jobhighlight_2) || str.startsWith(RNewActivity.this.jobhighlight_2_s) || str.startsWith(RNewActivity.this.jobhighlight_3) || str.equals(RNewActivity.this.jobhighlight_3_s) || str.startsWith(RNewActivity.this.jobhighlight_4) || str.startsWith(RNewActivity.this.jobhighlight_4_s) || str.startsWith(RNewActivity.this.jobhighlight_5) || str.startsWith(RNewActivity.this.jobhighlight_5_s) || str.startsWith(RNewActivity.this.jobhighlight_6) || str.startsWith(RNewActivity.this.jobhighlight_6_s)) {
                    Intent intent4 = new Intent(RNewActivity.this, RNewActivity.class);
                    intent4.putExtra("passu", str);
                    RNewActivity.this.startActivity(intent4);
                    RNewActivity.this.websiteM();
                } else {
                    if (RNewActivity.this.mInterstitialAd.isLoaded()) {
                        RNewActivity.this.mInterstitialAd.show();
                        RNewActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                    RNewActivity.this.webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                return true;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                RNewActivity.this.progressBar.setVisibility(View.GONE);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                try {
                    webView.stopLoading();
                    webView.loadUrl("about:blank");
                    AlertDialog create = new AlertDialog.Builder(RNewActivity.this).create();
                    create.setCancelable(false);
                    create.setIcon(R.drawable.notify_icon_large);
                    create.setCanceledOnTouchOutside(false);
                    create.setTitle(Html.fromHtml("<font color='#FF6F00'>No Internet !</font>"));
                    create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                    create.setButton(-2, "Try Again", new DialogInterface.OnClickListener() {
                        /* class com.jobhighlight.apps.RNewActivity.AnonymousClass7.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (Build.VERSION.SDK_INT >= 17) {
                                RNewActivity.this.recreate();
                                return;
                            }
                            Intent intent = RNewActivity.this.getIntent();
                            RNewActivity.this.finish();
                            RNewActivity.this.startActivity(intent);
                        }
                    });
                    create.setButton(-1, "Back", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialogInterface, int i) {
                            RNewActivity.this.finish();
                        }
                    });
                    if (Build.VERSION.SDK_INT >= 19) {
                        ((Window) Objects.requireNonNull(create.getWindow())).getAttributes().windowAnimations = R.style.DialogTheme1;
                    }
                    create.show();
                    Button button = create.getButton(-2);
                    if (button != null) {
                        button.setTextColor(RNewActivity.this.getResources().getColor(R.color.colorPrimary));
                    }
                    Typeface createFromAsset = Typeface.createFromAsset(RNewActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
                    //   ((TextView) create.findViewById(16908299)).setTypeface(createFromAsset);
                    ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
                } catch (Exception unused) {
                }
                if (webView.canGoBack()) {
                    webView.goBack();
                }
                super.onReceivedError(webView, i, str, str2);
            }
        });
        if(url == null){
            startActivity(new Intent(RNewActivity.this,MainActivity.class));
        }else if (this.url.toLowerCase().endsWith(".pdf") || this.url.toLowerCase().endsWith(".docx") || this.url.toLowerCase().startsWith("https://drive")) {
            this.webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.url)));
            finish();
        }else if (this.url.startsWith(this.play_store) || this.url.startsWith(this.yt)) {
            this.webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.url)));
            finish();
            return;
        }
        this.webView.loadUrl(this.url);
        this.webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                RNewActivity.this.progressBar.setProgress(i);
                ActionBar supportActionBar = RNewActivity.this.getSupportActionBar();
                supportActionBar.setTitle(RNewActivity.this.getString(R.string.app_full_name));
                supportActionBar.setSubtitle(RNewActivity.this.getTitle());
                RNewActivity.this.setTitle(R.string.OJN);
                super.onProgressChanged(webView, i);
            }
        });
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void websiteM() {
        this.countM++;
        if (this.mInterstitialAd.isLoaded() && this.countM >= this.triggerMaps) {
            this.mInterstitialAd.show();
            this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            this.countM = 0;
            int i = this.triggerMaps;
            if (i < 7) {
                this.triggerMaps = i + 1;
            }
        }
    }  public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hdr_right, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.reload_r:
                webView.reload();

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
    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            finish();
        }
    }

}