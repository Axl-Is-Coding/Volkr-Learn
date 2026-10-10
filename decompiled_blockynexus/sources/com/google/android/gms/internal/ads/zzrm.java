package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzrm implements Runnable {
    final /* synthetic */ zzrk zzbte;
    private ValueCallback<String> zzbts = new zzrl(this);
    final /* synthetic */ zzre zzbtt;
    final /* synthetic */ WebView zzbtu;
    final /* synthetic */ boolean zzbtv;

    zzrm(zzrk zzrkVar, zzre zzreVar, WebView webView, boolean z) {
        this.zzbte = zzrkVar;
        this.zzbtt = zzreVar;
        this.zzbtu = webView;
        this.zzbtv = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbtu.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbtu.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbts);
            } catch (Throwable unused) {
                this.zzbts.onReceiveValue("");
            }
        }
    }
}
