package com.infowebmentsolution.jobhighlight;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Objects;

public class EWActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String active = "false";

    String url;

    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    private WebView mWebView;
    String play_store;
    Intent rateapp;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        active = "true";
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_ew);
        getSupportActionBar().setElevation(0.0f);
        getSupportActionBar().hide();
        if(Build.VERSION.SDK_INT >= 21){
            Window window = getWindow();
            window.addFlags(-2147483648);
            window.setStatusBarColor(getResources().getColor(R.color.primaryYlw));
        }

        SwipeRefreshLayout swipeRefreshLayout1 = findViewById(R.id.swiperefresh1);
        this.swipeRefreshLayout = swipeRefreshLayout1;
        swipeRefreshLayout1.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeColors(Color.rgb(255, 28, 0), Color.rgb(57, 82, 96), Color.rgb(76, 175, 80), Color.rgb(255, 170, 6));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.active.equals(true)){
                    EWActivity.this.finish();
                    return;
                }
                EWActivity.this.startActivity(new Intent(EWActivity.this, MainActivity.class));
            }
        });

        if(Build.VERSION.SDK_INT >=19){
           ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setDisplayUseLogoEnabled(true);
        }

        if(Build.VERSION.SDK_INT>=19){
            ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setHomeAsUpIndicator((int) R.drawable.ic_back);

        }
        final WebView webView = findViewById(R.id.webView3);





        if (!CheckConnectionActivity.checkInternetConnection(this)) {
            try{
                webView.stopLoading();
                webView.loadUrl("about:blank");
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setCancelable(false);
                alertDialog.setIcon((int)R.drawable.notify_icon_large);
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setTitle(Html.fromHtml("<font color='#dea80e'>No Internet</font>"));
                alertDialog.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                alertDialog.setButton(-2, (CharSequence) "Try Again", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(Build.VERSION.SDK_INT>=17){
                            EWActivity.this.recreate();
                            return;
                        }
                        Intent intent = EWActivity.this.getIntent();
                        EWActivity.this.finish();
                        EWActivity.this.startActivity(intent);
                    }
                });
                alertDialog.setButton(-1, (CharSequence) "Back", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EWActivity.this.finish();
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
            }catch (Exception e){}

            if(webView.canGoBack()){
                webView.goBack();
                return;
            }

            this.progressBar = findViewById(R.id.progressbar3);
            if(Build.VERSION.SDK_INT >= 21){
                this.progressBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.primaryYlw)));
            }
            this.progressBar.setMax(100);
            this.url = getIntent().getStringExtra("passu");
            webView.setVerticalScrollBarEnabled(false);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setLongClickable(true);
            webView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return true;
                }
            });
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(false);
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            webSettings.setUseWideViewPort(true);
            webView.setWebViewClient(new WebViewClient() {
                static final /* synthetic */ boolean $assertionsDisabled = false;

                {
                    Class<MainActivity> cls = MainActivity.class;
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String UrL) {
                    ((AudioManager) EWActivity.this.getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(5);
                    Log.d("am1", UrL);
                    if(UrL.startsWith(EWActivity.this.play_store)){
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(EWActivity.this.url)));
                    return  true;
                    }
                    view.loadUrl(UrL);
                    return false;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    EWActivity.this.swipeRefreshLayout.setRefreshing(false);
                    EWActivity.this.progressBar.setVisibility(View.GONE);

                }

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    try {
                        view.stopLoading();
                        view.loadUrl("about:blank");
                        AlertDialog create = new AlertDialog.Builder(EWActivity.this).create();
                        view.loadUrl("about:blank");
                        create.setCancelable(false);
                        create.setIcon((int) R.drawable.notify_icon_large);
                        create.setCanceledOnTouchOutside(false);
                        create.setTitle(Html.fromHtml("<font color='#FF6F00'>No Internet !</font>"));
                        create.setMessage("Cannot connect to the Server. Check your internet connection and try again.");
                        create.setButton(-2, (CharSequence) "Try Again", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (Build.VERSION.SDK_INT >= 17) {
                                    EWActivity.this.recreate();
                                    return;
                                }
                                Intent intent = EWActivity.this.getIntent();
                                EWActivity.this.finish();
                                EWActivity.this.startActivity(intent);
                            }
                        });
                        create.setButton(-1, (CharSequence) "Back", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EWActivity.this.finish();
                            }
                        });
                        if (Build.VERSION.SDK_INT >= 19) {
                            ((Window) Objects.requireNonNull(create.getWindow())).getAttributes().windowAnimations = R.style.DialogTheme1;
                        }
                        create.show();
                        Button button = create.getButton(-2);
                        if (button != null) {
                            button.setTextColor(EWActivity.this.getResources().getColor(R.color.colorPrimary));
                        }
                        Typeface createFromAsset = Typeface.createFromAsset(EWActivity.this.getAssets(), "lib/asstes/font/ArchivoBlack-Regular.ttf");
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
            this.swipeRefreshLayout.setRefreshing(false);
            this.mWebView.setWebChromeClient(new WebChromeClient());
            this.mWebView.setWebChromeClient(new WebChromeClient(){
                static final /* synthetic*/ boolean $assertionDisable = false;
                 {
                    Class<EWActivity> cls = EWActivity.class;
                 }

                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                     EWActivity.this.progressBar.setProgress(newProgress);
                     ActionBar supportActionBar = EWActivity.this.getSupportActionBar();
                  //   supportActionBar.setTitle((CharSequence) EWActivity.this.getString(R.string.app_full_name));
                     supportActionBar.setSubtitle(EWActivity.this.getTitle());
                    if(newProgress == 100){
                        EWActivity.this.progressBar.setVisibility(View.GONE);
                        EWActivity.this.setTitle(view.getTitle());
                    }else EWActivity.this.progressBar.setVisibility(View.VISIBLE);
                     super.onProgressChanged(view, newProgress);
                }
            });

        }
    }


    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
        } else if (MainActivity.active.equals(true)) {
            finish();
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void onRefresh() {
        this.swipeRefreshLayout.setRefreshing(true);
        this.mWebView.clearCache(true);
        this.mWebView.reload();
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
}