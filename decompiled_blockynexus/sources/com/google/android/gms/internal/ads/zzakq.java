package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzakq implements Runnable {
    private final /* synthetic */ zzakk zzdhc;
    private final /* synthetic */ String zzdhe;

    zzakq(zzakk zzakkVar, String str) {
        this.zzdhc = zzakkVar;
        this.zzdhe = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdhc.zzdgy.loadUrl(this.zzdhe);
    }
}
