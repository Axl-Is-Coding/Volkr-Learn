package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzczt implements zzdyr<zzcbe> {
    private final /* synthetic */ zzcce zzgti;
    final /* synthetic */ zzczu zzgtj;

    zzczt(zzczu zzczuVar, zzcce zzcceVar) {
        this.zzgtj = zzczuVar;
        this.zzgti = zzcceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzcbe zzcbeVar) {
        zzcbe zzcbeVar2 = zzcbeVar;
        synchronized (this.zzgtj) {
            zzczu.zza(this.zzgtj, (zzdzc) null);
            this.zzgtj.zzgtl = zzcbeVar2;
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyh)).booleanValue()) {
                zzcbeVar2.zzaiz().zza(this.zzgtj.zzgsq).zza(this.zzgtj.zzgss).zza(this.zzgtj.zzgst).zza(this.zzgtj.zzgtk);
            }
            zzcbeVar2.zzaih();
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyh)).booleanValue()) {
                this.zzgtj.zzgpt.zzadi().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzczw
                    private final zzczt zzgtn;

                    {
                        this.zzgtn = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgtn.zzgtj.zzgsq.onAdLoaded();
                    }
                });
                this.zzgtj.zzgpt.zzadi().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzczv
                    private final zzczt zzgtn;

                    {
                        this.zzgtn = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgtn.zzgtj.zzgtk.onAdLoaded();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        final zzva zzvaVarZze = this.zzgti.zzaev().zze(th);
        synchronized (this.zzgtj) {
            zzczu.zza(this.zzgtj, (zzdzc) null);
            this.zzgti.zzaew().zzk(zzvaVarZze);
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcye)).booleanValue()) {
                this.zzgtj.zzgpt.zzadi().execute(new Runnable(this, zzvaVarZze) { // from class: com.google.android.gms.internal.ads.zzczy
                    private final zzva zzgte;
                    private final zzczt zzgtn;

                    {
                        this.zzgtn = this;
                        this.zzgte = zzvaVarZze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzczt zzcztVar = this.zzgtn;
                        zzcztVar.zzgtj.zzgsq.zzk(this.zzgte);
                    }
                });
                this.zzgtj.zzgpt.zzadi().execute(new Runnable(this, zzvaVarZze) { // from class: com.google.android.gms.internal.ads.zzczx
                    private final zzva zzgte;
                    private final zzczt zzgtn;

                    {
                        this.zzgtn = this;
                        this.zzgte = zzvaVarZze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzczt zzcztVar = this.zzgtn;
                        zzcztVar.zzgtj.zzgtk.zzk(this.zzgte);
                    }
                });
            }
            zzdox.zza(zzvaVarZze.errorCode, th, "InterstitialAdManagerShim.onFailure");
        }
    }
}
