package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzczz implements zzdag<zzbqo> {
    private final /* synthetic */ zzdaa zzgto;

    zzczz(zzdaa zzdaaVar) {
        this.zzgto = zzdaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final /* synthetic */ void onSuccess(zzbqo zzbqoVar) {
        zzbqo zzbqoVar2 = zzbqoVar;
        synchronized (this.zzgto) {
            zzdaa.zza(this.zzgto, false);
            this.zzgto.zzadt = zzbqoVar2.zzaix();
            zzbqoVar2.zzaih();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzaqv() {
        synchronized (this.zzgto) {
            zzdaa.zza(this.zzgto, false);
        }
    }
}
