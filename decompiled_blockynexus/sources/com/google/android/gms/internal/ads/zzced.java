package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzced {
    private zzadz zzckt;

    public zzced(zzcdv zzcdvVar) {
        this.zzckt = zzcdvVar;
    }

    public final synchronized void zza(zzadz zzadzVar) {
        this.zzckt = zzadzVar;
    }

    public final synchronized zzadz zzsw() {
        return this.zzckt;
    }
}
