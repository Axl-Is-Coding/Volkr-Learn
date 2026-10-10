package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzbil extends WebView {
    public zzbil(Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        com.google.android.gms.ads.internal.zzp.zzkt().zza(getContext(), settings);
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            zzbbq.zzc("Unable to enable Javascript.", e2);
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            zzayp.zzei("Ignore addJavascriptInterface due to low Android version.");
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "CoreWebView.loadUrl");
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public void zzdc(String str) {
        zzbio.zza(this, str);
    }
}
