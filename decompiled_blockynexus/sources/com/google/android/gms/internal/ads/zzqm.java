package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqm implements Runnable {
    private final /* synthetic */ zzqg zzbmx;
    private final /* synthetic */ Surface zzbnf;

    zzqm(zzqg zzqgVar, Surface surface) {
        this.zzbmx = zzqgVar;
        this.zzbnf = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmx.zzbmy.zza(this.zzbnf);
    }
}
