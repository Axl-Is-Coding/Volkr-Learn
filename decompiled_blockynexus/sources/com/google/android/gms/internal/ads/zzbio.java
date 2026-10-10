package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbio {

    @VisibleForTesting
    private static Boolean zzeqy;

    private zzbio() {
    }

    @TargetApi(19)
    static void zza(WebView webView, String str) {
        if (PlatformVersion.isAtLeastKitKat() && zzb(webView)) {
            webView.evaluateJavascript(str, null);
        } else {
            String strValueOf = String.valueOf(str);
            webView.loadUrl(strValueOf.length() != 0 ? "javascript:".concat(strValueOf) : new String("javascript:"));
        }
    }

    @TargetApi(19)
    private static boolean zzb(WebView webView) {
        boolean zBooleanValue;
        synchronized (zzbio.class) {
            if (zzeqy == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zzeqy = true;
                } catch (IllegalStateException unused) {
                    zzeqy = false;
                }
                zBooleanValue = zzeqy.booleanValue();
            } else {
                zBooleanValue = zzeqy.booleanValue();
            }
        }
        return zBooleanValue;
    }
}
