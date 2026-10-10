package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxx implements Runnable {
    private final /* synthetic */ zzdxu zzhsm;
    private final /* synthetic */ zzdzc zzhsn;
    private final /* synthetic */ int zzhso;

    zzdxx(zzdxu zzdxuVar, zzdzc zzdzcVar, int i) {
        this.zzhsm = zzdxuVar;
        this.zzhsn = zzdzcVar;
        this.zzhso = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzhsn.isCancelled()) {
                zzdxu.zza(this.zzhsm, (zzdwk) null);
                this.zzhsm.cancel(false);
            } else {
                this.zzhsm.zza(this.zzhso, this.zzhsn);
            }
        } finally {
            this.zzhsm.zza((zzdwk) null);
        }
    }
}
