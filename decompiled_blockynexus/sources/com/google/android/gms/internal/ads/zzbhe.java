package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public final class zzbhe<WebViewT extends zzbhi & zzbhq & zzbhs> {
    private final zzbhj zzeqh;
    private final WebViewT zzeqi;

    private zzbhe(WebViewT webviewt, zzbhj zzbhjVar) {
        this.zzeqh = zzbhjVar;
        this.zzeqi = webviewt;
    }

    public static zzbhe<zzbgj> zzc(final zzbgj zzbgjVar) {
        return new zzbhe<>(zzbgjVar, new zzbhj(zzbgjVar) { // from class: com.google.android.gms.internal.ads.zzbhh
            private final zzbgj zzeqk;

            {
                this.zzeqk = zzbgjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhj
            public final void zzh(Uri uri) {
                zzbhv zzbhvVarZzabw = this.zzeqk.zzabw();
                if (zzbhvVarZzabw == null) {
                    zzbbq.zzfc("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                } else {
                    zzbhvVarZzabw.zzh(uri);
                }
            }
        });
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzayp.zzei("Click string is empty, not proceeding.");
            return "";
        }
        zzeg zzegVarZzabz = this.zzeqi.zzabz();
        if (zzegVarZzabz == null) {
            zzayp.zzei("Signal utils is empty, ignoring.");
            return "";
        }
        zzdw zzdwVarZzca = zzegVarZzabz.zzca();
        if (zzdwVarZzca == null) {
            zzayp.zzei("Signals object is empty, ignoring.");
            return "";
        }
        if (this.zzeqi.getContext() != null) {
            return zzdwVarZzca.zza(this.zzeqi.getContext(), str, this.zzeqi.getView(), this.zzeqi.zzzu());
        }
        zzayp.zzei("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public final void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            zzbbq.zzfe("URL is empty, ignoring message");
        } else {
            zzayu.zzeba.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzbhg
                private final String zzdgm;
                private final zzbhe zzeqj;

                {
                    this.zzeqj = this;
                    this.zzdgm = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeqj.zzfu(this.zzdgm);
                }
            });
        }
    }

    final /* synthetic */ void zzfu(String str) {
        this.zzeqh.zzh(Uri.parse(str));
    }
}
