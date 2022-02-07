package com.infowebmentsolution.jobhighlight;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
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
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
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

public class ExamLinkMainActivity extends AppCompatActivity {

    static final /* synthetic */ boolean $assertionsDisabled = false;



    String url;
    int countM = 0;
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
    String play_store;
    String tlg;
    String wap;
    String YT;
    String amz;
    public AdView mAdView;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    private WebView mWebView;
    WebView webView;
    Intent rateapp;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;


    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        setContentView((int) R.layout.activity_jlnk);

        if (Build.VERSION.SDK_INT >= 21) {
            ((ActionBar) Objects.requireNonNull((getSupportActionBar()))).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primaryYlw)));
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.primaryYlw));//e_live
        }


        if (Build.VERSION.SDK_INT >= 19) {
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setElevation(0.0f);
        }

        this.webView = findViewById(R.id.webView3);
        if (!CheckConnectionActivity.checkInternetConnection(this)) {
            try {
                webView.stopLoading();
                webView.loadUrl("about:blank");
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setCancelable(false);
                alertDialog.setIcon((int) R.drawable.notify_icon_large);
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setTitle(Html.fromHtml("<font color='#dea80e'>No Internet</font>"));
                alertDialog.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                alertDialog.setButton(-2, (CharSequence) "Try Again", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            ExamLinkMainActivity.this.recreate();
                            return;
                        }
                        Intent intent = ExamLinkMainActivity.this.getIntent();
                        ExamLinkMainActivity.this.finish();
                        ExamLinkMainActivity.this.startActivity(intent);
                    }
                });
                alertDialog.setButton(-1, (CharSequence) "Exit Exam", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ExamLinkMainActivity.this.finish();
                    }
                });
                if (Build.VERSION.SDK_INT >= 19) {
                    ((Window) Objects.requireNonNull(alertDialog.getWindow())).getAttributes().windowAnimations = R.style.DialogTheme1;
                }
                alertDialog.show();
                Button button = alertDialog.getButton(-2);
                if (button != null) {
                    button.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                Typeface createFromAsset = Typeface.createFromAsset(ExamLinkMainActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
                //    ((TextView) alertDialog.findViewById(16908299)).setTypeface(createFromAsset);
                ((TextView) alertDialog.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
            } catch (Exception e) {}

            if (webView.canGoBack()) {
                this.webView.goBack();
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

        MobileAds.initialize((Context) this, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        new AdView(this).setAdUnitId(getString(R.string.app_adcode_id));
        this.mAdView = (AdView) findViewById(R.id.adView3);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.mAdView.setAdListener(new AdListener() {
            public void onAdClosed() {
                ExamLinkMainActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ExamLinkMainActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }
        });
        InterstitialAd interstitialAd = new InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(getString(R.string.app_adunit));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                ExamLinkMainActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ExamLinkMainActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

         this.progressBar =(ProgressBar) findViewById(R.id.progressbar2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.progressBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.primaryYlw)));
        }

        this.progressBar.setMax(100);
        this.url = getIntent().getStringExtra("passu");
        this.webView.setVerticalScrollBarEnabled(false);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        this.webView.setLongClickable(true);
        this.webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
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


        this.webView.setWebViewClient(new WebViewClient(){

            static final /* synthetic */ boolean $assertionsDisabled = false;


            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                String str2;
                try {
                    str2 = new URL(url).getPath();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    str2 = "";
                }
                ((AudioManager) ExamLinkMainActivity.this.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(5);

                if (url.equals(ExamLinkMainActivity.this.jhlHome)) {
                    return false;
                }

                if ((url.startsWith(ExamLinkMainActivity.this.jhl1) || url.startsWith(ExamLinkMainActivity.this.jhl2) ||
                        url.startsWith(ExamLinkMainActivity.this.jhl3) || url.startsWith(ExamLinkMainActivity.this.jhl4)||
                        url.startsWith(ExamLinkMainActivity.this.jhl5) || url.equals(ExamLinkMainActivity.this.jhl6) ||
                        url.startsWith(ExamLinkMainActivity.this.jhl7)||url.startsWith(ExamLinkMainActivity.this.jhl9)
                        || url.startsWith(ExamLinkMainActivity.this.jhl10) || url.startsWith(ExamLinkMainActivity.this.jhl12)) && url.startsWith("/subject")){
                    Intent intent = new Intent(ExamLinkMainActivity.this, ExamLinkMainActivity.class);
                    intent.putExtra("passURL", url);
                    ExamLinkMainActivity.this.startActivity(intent);
                    return true;
                } else if (url.toLowerCase().endsWith(".pdf")) {
                    Intent intent2 = new Intent(ExamLinkMainActivity.this, ExamLinkActivity.class);
                    intent2.putExtra("passu", url);
                    ExamLinkMainActivity.this.startActivity(intent2);
                    return true;
                } else if (url.toLowerCase().startsWith(ExamLinkMainActivity.this.amz) || url.toLowerCase().startsWith(ExamLinkMainActivity.this.flk)
                        ||((url.startsWith(ExamLinkMainActivity.this.jhl1) || url.startsWith(ExamLinkMainActivity.this.jhl2)) && url.toLowerCase().endsWith("affiliate/"))) {
                    Intent intent3 = new Intent(ExamLinkMainActivity.this, EWActivity.class);
                    intent3.putExtra("passu", url);
                    ExamLinkMainActivity.this.startActivity(intent3);
                    return true;
                } else if (url.startsWith(ExamLinkMainActivity.this.play_store) || url.startsWith(ExamLinkMainActivity.this.YT) ||
                        url.startsWith(ExamLinkMainActivity.this.wap) ||url.startsWith(ExamLinkMainActivity.this.f_b) ||
                        url.startsWith(ExamLinkMainActivity.this.e_mail) || url.startsWith(ExamLinkMainActivity.this.tlg)) {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                }
                else if (url.startsWith(ExamLinkMainActivity.this.jhl1) || url.startsWith(ExamLinkMainActivity.this.jhl2) ||
                        url.startsWith(ExamLinkMainActivity.this.jhl3) || url.startsWith(ExamLinkMainActivity.this.jhl4) ||
                        url.startsWith(ExamLinkMainActivity.this.jhl5) || url.startsWith(ExamLinkMainActivity.this.jhl6) ||
                        url.startsWith(ExamLinkMainActivity.this.jhl7) || url.startsWith(ExamLinkMainActivity.this.jhl8) ||
                        url.startsWith(ExamLinkMainActivity.this.jhl9) || url.startsWith(ExamLinkMainActivity.this.jhl10) ||
                        url.startsWith(ExamLinkMainActivity.this.jhl11) || url.startsWith(ExamLinkMainActivity.this.jhl12)) {
                    Intent intent4 = new Intent(ExamLinkMainActivity.this, CLinkActivity.class);
                    intent4.putExtra("passu", url);
                    ExamLinkMainActivity.this.startActivity(intent4);
                    return true;
                }
                else {

                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                }
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                ExamLinkMainActivity.this.progressBar.setVisibility(View.GONE);
            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                try {
                    webView.stopLoading();
                }catch (Exception e){}
                if (webView.canGoBack()){
                    webView.goBack();
                }
                    view.stopLoading();
                    view.loadUrl("about:blank");
                    AlertDialog create = new AlertDialog.Builder(ExamLinkMainActivity.this).create();
                    view.loadUrl("about:blank");
                    create.setCancelable(false);
                    create.setIcon((int) R.drawable.notify_icon_large);
                    create.setCanceledOnTouchOutside(false);
                    create.setTitle(Html.fromHtml("<font color='#FF6F00'>No Internet !</font>"));
                    create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                    create.setButton(-2, (CharSequence) "Try Again", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (Build.VERSION.SDK_INT >= 17) {
                                ExamLinkMainActivity.this.recreate();
                                return;
                            }
                            Intent intent = ExamLinkMainActivity.this.getIntent();
                            ExamLinkMainActivity.this.finish();
                            ExamLinkMainActivity.this.startActivity(intent);
                        }
                    });
                    create.setButton(-1, (CharSequence) "Exit Exam", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ExamLinkMainActivity.this.finish();
                        }
                    });
                    create.show();
                    Button button = create.getButton(-2);
                    if (button != null) {
                        button.setTextColor(ExamLinkMainActivity.this.getResources().getColor(R.color.primaryYlw));
                    }
                    Typeface createFromAsset = Typeface.createFromAsset(ExamLinkMainActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
                   //  ((TextView) create.findViewById(16908299)).setTypeface(createFromAsset);
                    ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);


                super.onReceivedError(view,request,error);
            }

        });
        if (this.url.toLowerCase().endsWith(".pdf") || this.url.toLowerCase().endsWith(".docx") || this.url.toLowerCase().startsWith("https://drive")) {
            this.webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.url)));
        }else if (this.url.startsWith("https://play.google.com") || this.url.startsWith("https://www.youtube.com")) {
            startActivity(new Intent(this, MainActivity.class));
            this.webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.url)));
            finish();
        }else {
            this.webView.loadUrl(this.url);
            this.progressBar.setProgress(0);
            this.webView.setWebChromeClient(new WebChromeClient());
            this.webView.setWebChromeClient(new WebChromeClient(){


                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    ExamLinkMainActivity.this.progressBar.setProgress(newProgress);
                    ActionBar bar = ExamLinkMainActivity.this.getSupportActionBar();
                 //   bar.setTitle(ExamLinkMainActivity.this.getString(R.string.app_full_name));
         //           bar.setSubtitle(R.string.OJN);
                    if(newProgress == 100){
                        ExamLinkMainActivity.this.progressBar.setVisibility(View.GONE);
                    }else ExamLinkMainActivity.this.progressBar.setVisibility(View.VISIBLE);

                    super.onProgressChanged(view, newProgress);
                }
            });
        }
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

    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setIcon(R.drawable.notify_icon_large);
        alertDialog.setTitle(Html.fromHtml("<font color='#dea80e'>Close Exam</font>"));
        alertDialog.setMessage("Do you want to Exit from Online Examination?");
        alertDialog.setButton(-2, (CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.setButton(-1, (CharSequence) "Exit Exam", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ExamLinkMainActivity.this.finish();
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            ((Window) Objects.requireNonNull(alertDialog.getWindow())).getAttributes().windowAnimations = R.style.DialogTheme1;
        }
        alertDialog.show();
        Button button = alertDialog.getButton(-2);
        if (button != null) {
            button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

}