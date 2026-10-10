package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxw implements Runnable {
    private final /* synthetic */ zzdwk zzhsl;
    private final /* synthetic */ zzdxu zzhsm;

    zzdxw(zzdxu zzdxuVar, zzdwk zzdwkVar) {
        this.zzhsm = zzdxuVar;
        this.zzhsl = zzdwkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhsm.zza(this.zzhsl);
    }
}
