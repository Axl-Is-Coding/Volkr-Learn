package io.rong.common.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes5.dex */
public class SSLUtils {
    private static HostnameVerifier sHostnameVerifier;
    private static SSLContext sSSLContext;

    public static HostnameVerifier getHostVerifier() {
        return sHostnameVerifier;
    }

    public static SSLContext getSSLContext() {
        return sSSLContext;
    }

    public static void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        sHostnameVerifier = hostnameVerifier;
    }

    public static void setSSLContext(SSLContext sSLContext) {
        sSSLContext = sSLContext;
    }
}
