package com.alibaba.sdk.android.feedback.xblink.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3894a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3895b = "f";

    public static HttpHost a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (Build.VERSION.SDK_INT >= 11) {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return new HttpHost(property, Integer.parseInt(property2));
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            g.b(f3895b, e2 + "");
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || activeNetworkInfo.getType() != 0) {
            return null;
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost != null) {
            return new HttpHost(defaultHost, defaultPort);
        }
        return null;
    }
}
