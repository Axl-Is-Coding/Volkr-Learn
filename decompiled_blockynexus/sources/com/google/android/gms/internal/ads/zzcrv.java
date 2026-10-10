package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcrv implements Callable {
    private final zzcru zzglv;

    private zzcrv(zzcru zzcruVar) {
        this.zzglv = zzcruVar;
    }

    static Callable zza(zzcru zzcruVar) {
        return new zzcrv(zzcruVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzglv.getWritableDatabase();
    }
}
