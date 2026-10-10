package io.rong.imlib.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import io.rong.common.utils.SSLUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes5.dex */
public class NetUtils {
    private static final String TAG = "NetUtils";
    private static Boolean isLatestNetWorkAvailable;

    public static HttpURLConnection createURLConnection(String str) throws IOException {
        if (!str.toLowerCase().startsWith("https")) {
            return (HttpURLConnection) new URL(str).openConnection();
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        SSLContext sSLContext = SSLUtils.getSSLContext();
        if (sSLContext != null) {
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        }
        HostnameVerifier hostVerifier = SSLUtils.getHostVerifier();
        if (hostVerifier == null) {
            return httpsURLConnection;
        }
        httpsURLConnection.setHostnameVerifier(hostVerifier);
        return httpsURLConnection;
    }

    public static boolean getCacheNetworkAvailable(Context context) {
        if (isLatestNetWorkAvailable == null) {
            isLatestNetWorkAvailable = Boolean.valueOf(isNetWorkAvailable(context));
        }
        return isLatestNetWorkAvailable.booleanValue();
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isNetWorkAvailable(Context context) {
        String str;
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = null;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("network : ");
            if (activeNetworkInfo != null) {
                str = activeNetworkInfo.isAvailable() + " " + activeNetworkInfo.isConnected();
            } else {
                str = "null";
            }
            sb.append(str);
            Log.d(str2, sb.toString());
        } catch (Exception e2) {
            Log.e(TAG, "getActiveNetworkInfo Exception", e2);
        }
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static void updateCacheNetworkAvailable(boolean z) {
        isLatestNetWorkAvailable = Boolean.valueOf(z);
    }
}
