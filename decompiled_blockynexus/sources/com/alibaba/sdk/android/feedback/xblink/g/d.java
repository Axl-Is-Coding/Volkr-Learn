package com.alibaba.sdk.android.feedback.xblink.g;

import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static X509TrustManager f3879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3880b = "d";

    public static X509TrustManager a() {
        if (f3879a == null) {
            try {
                f3879a = new a();
            } catch (Exception e2) {
                e2.printStackTrace();
                f3879a = null;
            }
        }
        return f3879a;
    }
}
