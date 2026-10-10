package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public class zzbhn extends zzbgi {
    public zzbhn(zzbgj zzbgjVar, zzts zztsVar, boolean z) {
        super(zzbgjVar, zztsVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbgj)) {
            zzbbq.zzfe("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbgj zzbgjVar = (zzbgj) webView;
        zzawl zzawlVar = this.zzenb;
        if (zzawlVar != null) {
            zzawlVar.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbgjVar.zzabw() != null) {
            zzbgjVar.zzabw().zzuu();
        }
        if (zzbgjVar.zzabu().zzadb()) {
            str2 = (String) zzwm.zzpx().zzd(zzabb.zzcmz);
        } else if (zzbgjVar.zzacb()) {
            str2 = (String) zzwm.zzpx().zzd(zzabb.zzcmy);
        } else {
            str2 = (String) zzwm.zzpx().zzd(zzabb.zzcmx);
        }
        com.google.android.gms.ads.internal.zzp.zzkr();
        return zzayu.zzd(zzbgjVar.getContext(), zzbgjVar.zzzx().zzbre, str2);
    }
}
