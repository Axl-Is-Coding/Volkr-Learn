package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcaz implements zzsu {
    private zzdvp zzfwp;

    @Override // com.google.android.gms.internal.ads.zzsu
    public final View getView() {
        return this.zzfwp;
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final WebView getWebView() {
        if (this.zzfwp == null) {
            return null;
        }
        return zzdvp.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.zzfwp != null) {
            zzdvp.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final void zza(Activity activity, WebView webView) {
        try {
            this.zzfwp = new zzdvp(activity, webView);
        } catch (RuntimeException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 46);
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(strValueOf);
            zzbbq.zzfc(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final void zzc(String str, String str2) {
        if (this.zzfwp == null) {
            zzbbq.zzfc("ArWebView is not initialized.");
        } else {
            zzdvp.getWebView().loadDataWithBaseURL(str, str2, NanoHTTPD.MIME_HTML, "UTF-8", null);
        }
    }
}
