package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public final class zzbhk extends zzbhn {
    public zzbhk(zzbgj zzbgjVar, zzts zztsVar, boolean z) {
        super(zzbgjVar, zztsVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgi, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
