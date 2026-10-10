package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayd extends zzayl {
    private final /* synthetic */ zzayb zzdzk;

    zzayd(zzayb zzaybVar) {
        this.zzdzk = zzaybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzvb() {
        zzabf zzabfVar = new zzabf(this.zzdzk.zzvr, this.zzdzk.zzbpe.zzbre);
        synchronized (this.zzdzk.lock) {
            try {
                com.google.android.gms.ads.internal.zzp.zzla();
                zzabk.zza(this.zzdzk.zzdzc, zzabfVar);
            } catch (IllegalArgumentException e2) {
                zzbbq.zzd("Cannot config CSI reporter.", e2);
            }
        }
    }
}
