package com.google.android.gms.internal.ads;

import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzakn implements Runnable {
    private final /* synthetic */ String zzdhb;
    private final /* synthetic */ zzakk zzdhc;

    zzakn(zzakk zzakkVar, String str) {
        this.zzdhc = zzakkVar;
        this.zzdhb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdhc.zzdgy.loadData(this.zzdhb, NanoHTTPD.MIME_HTML, "UTF-8");
    }
}
