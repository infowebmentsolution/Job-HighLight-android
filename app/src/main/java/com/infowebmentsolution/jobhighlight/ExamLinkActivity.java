package com.infowebmentsolution.jobhighlight;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.Objects;

public class ExamLinkActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    String amazon;
    String e_mail;
    String f_b;
    String flipkart;
    /* access modifiers changed from: private */
    public AdView mAdView;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    String play_store;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    Intent rateapp;
    String t_lgrm;
    String url;
    WebView webView;
    String wht_app;
    String you_tube;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jlnk);

        //FOR SDK >=21
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
                            ExamLinkActivity.this.recreate();
                            return;
                        }
                        Intent intent = ExamLinkActivity.this.getIntent();
                        ExamLinkActivity.this.finish();
                        ExamLinkActivity.this.startActivity(intent);
                    }
                });
                alertDialog.setButton(-1, (CharSequence) "Exit Exam", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ExamLinkActivity.this.finish();
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
                Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
                //    ((TextView) alertDialog.findViewById(16908299)).setTypeface(createFromAsset);
                ((TextView) alertDialog.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
            } catch (Exception e) {
            }

            if (webView.canGoBack()) {
                this.webView.goBack();
                return;
            }
            return;

        }
        this.play_store = "https://play.google.com";
        this.you_tube = "https://www.youtube.com";
        this.wht_app = "whatsapp";
        this.f_b = "fb:";
        this.e_mail = "mailto";
        this.t_lgrm = "https://t.me/";
        this.amazon = "https://www.amazon.";
        this.flipkart = "https://www.flipkart.";

        MobileAds.initialize((Context) this,(OnInitializationCompleteListener) new OnInitializationCompleteListener(){
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        new AdView(this).setAdUnitId(getString(R.string.app_adcode_id));
        this.mAdView = findViewById(R.id.adView3);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                ExamLinkActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ExamLinkActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }
        });

        InterstitialAd interstitialAd = new InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(getString(R.string.app_adunit));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                ExamLinkActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ExamLinkActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
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

            {
                Class<ExamLinkActivity> cls = ExamLinkActivity.class;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                ((AudioManager) ExamLinkActivity.this.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(5);
                if(url.toLowerCase().startsWith(ExamLinkActivity.this.amazon)|| url.toLowerCase().startsWith(ExamLinkActivity.this.flipkart)){
                    Intent intent = new Intent(ExamLinkActivity.this,EWActivity.class);
                    intent.putExtra("passu",url);
                    ExamLinkActivity.this.startActivity(intent);
                    return  true;
                }else if(!url.startsWith(ExamLinkActivity.this.play_store) && !url.startsWith(ExamLinkActivity.this.you_tube) && !url.startsWith(ExamLinkActivity.this.wht_app) && !url.startsWith(ExamLinkActivity.this.f_b) && !url.startsWith(ExamLinkActivity.this.e_mail) && !url.startsWith(ExamLinkActivity.this.t_lgrm)){
                    return false;
                }else {
                    ExamLinkActivity.this.webView.getContext().startActivity(new Intent("android.inetnt.action.VIEW",Uri.parse(url)));
                    return  true;
                }

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                ExamLinkActivity.this.progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                try {
                    view.stopLoading();
                    view.loadUrl("about:blank");
                    AlertDialog create = new AlertDialog.Builder(ExamLinkActivity.this).create();
                    view.loadUrl("about:blank");
                    create.setCancelable(false);
                    create.setIcon((int) R.drawable.notify_icon_large);
                    create.setCanceledOnTouchOutside(false);
                    create.setTitle(Html.fromHtml("<font color='#FF6F00'>No Internet !</font>"));
                    create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                    create.setButton(-2, (CharSequence) "Try Again", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (Build.VERSION.SDK_INT >= 17) {
                                ExamLinkActivity.this.recreate();
                                return;
                            }
                            Intent intent = ExamLinkActivity.this.getIntent();
                            ExamLinkActivity.this.finish();
                            ExamLinkActivity.this.startActivity(intent);
                        }
                    });
                    create.setButton(-1, (CharSequence) "Back", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ExamLinkActivity.this.finish();
                        }
                    });
                    if (Build.VERSION.SDK_INT >= 19) {
                        ((Window) Objects.requireNonNull(create.getWindow())).getAttributes().windowAnimations = R.style.DialogTheme1;
                    }
                    create.show();
                    Button button = create.getButton(-2);
                    if (button != null) {
                        button.setTextColor(ExamLinkActivity.this.getResources().getColor(R.color.colorPrimary));
                    }
                    Typeface createFromAsset = Typeface.createFromAsset(ExamLinkActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
                    // ((TextView) create.findViewById(16908299)).setTypeface(createFromAsset);
                    ((TextView) create.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
                } catch (Exception unused) {
                }
                if (view.canGoBack()) {
                    view.goBack();
                }
                super.onReceivedError(view,request,error);
            }
        });
        webView.loadUrl(this.url);
        this.progressBar.setProgress(0);
        this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.setWebChromeClient(new WebChromeClient(){
            static final /* synthetic*/ boolean $assertionDisable = false;
            {
                Class<EWActivity> cls = EWActivity.class;
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                ExamLinkActivity.this.progressBar.setProgress(newProgress);
                ActionBar supportActionBar = ExamLinkActivity.this.getSupportActionBar();
            //    supportActionBar.setTitle((CharSequence) ExamLinkActivity.this.getString(R.string.app_full_name));
               // supportActionBar.setSubtitle(R.string.OJN);
                if(newProgress == 100){
                    ExamLinkActivity.this.progressBar.setVisibility(View.GONE);
                    ExamLinkActivity.this.setTitle(view.getTitle());
                }else ExamLinkActivity.this.progressBar.setVisibility(View.VISIBLE);
                super.onProgressChanged(view, newProgress);
            }
        });

    }


    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setIcon((int) R.drawable.notify_icon_large);
        alertDialog.setTitle(Html.fromHtml("<font color='#dea80e'>Close Exam</font>"));
        alertDialog.setMessage("Do you want to Exit from Online Examination?");
        alertDialog.setButton(-2, (CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.setButton(-1, (CharSequence) "Exit Exam", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ExamLinkActivity.this.finish();
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
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
        // ((TextView) alertDialog.findViewById(16908299)).setTypeface(createFromAsset);
        ((TextView) alertDialog.findViewById(R.id.alertTitle)).setTypeface(createFromAsset);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
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
}