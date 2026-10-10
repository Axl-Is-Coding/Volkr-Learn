package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbbq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzm extends WebViewClient {
    private final /* synthetic */ zzj zzbpm;

    zzm(zzj zzjVar) {
        this.zzbpm = zzjVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zzbpm.zzbpj != null) {
            try {
                this.zzbpm.zzbpj.onAdFailedToLoad(0);
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zzbpm.zzkm())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (this.zzbpm.zzbpj != null) {
                try {
                    this.zzbpm.zzbpj.onAdFailedToLoad(3);
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
            this.zzbpm.zzbt(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            if (this.zzbpm.zzbpj != null) {
                try {
                    this.zzbpm.zzbpj.onAdFailedToLoad(0);
                } catch (RemoteException e3) {
                    zzbbq.zze("#007 Could not call remote method.", e3);
                }
            }
            this.zzbpm.zzbt(0);
            return true;
        }
        if (str.startsWith("gmsg://adResized")) {
            if (this.zzbpm.zzbpj != null) {
                try {
                    this.zzbpm.zzbpj.onAdLoaded();
                } catch (RemoteException e4) {
                    zzbbq.zze("#007 Could not call remote method.", e4);
                }
            }
            this.zzbpm.zzbt(this.zzbpm.zzbq(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        if (this.zzbpm.zzbpj != null) {
            try {
                this.zzbpm.zzbpj.onAdLeftApplication();
            } catch (RemoteException e5) {
                zzbbq.zze("#007 Could not call remote method.", e5);
            }
        }
        this.zzbpm.zzbs(this.zzbpm.zzbr(str));
        return true;
    }
}
