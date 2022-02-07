package com.infowebmentsolution.jobhighlight;

import android.content.Context;
import android.net.ConnectivityManager;

public class CheckConnectionActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static boolean checkInternetConnection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}
