package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbin {
    private final String method;
    public final Uri uri;
    public final String url;
    public final Map<String, String> zzam;

    @TargetApi(21)
    public zzbin(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public zzbin(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private zzbin(String str, Uri uri, String str2, Map<String, String> map) {
        this.url = str;
        this.uri = uri;
        this.method = str2 == null ? "GET" : str2;
        this.zzam = map == null ? Collections.emptyMap() : map;
    }
}
