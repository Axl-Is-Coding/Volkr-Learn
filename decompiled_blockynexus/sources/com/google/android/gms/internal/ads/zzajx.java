package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzajx {
    private final zzake zzdgp;

    private zzajx(zzake zzakeVar) {
        this.zzdgp = zzakeVar;
    }

    @JavascriptInterface
    public final void notify(String str) {
        this.zzdgp.zzdg(str);
    }
}
