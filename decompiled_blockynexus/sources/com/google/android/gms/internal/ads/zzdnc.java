package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdnc implements zzdyr<zzcjg> {
    private final /* synthetic */ zzdag zzgty;
    private final /* synthetic */ zzdnh zzhcs;
    final /* synthetic */ zzdnb zzhct;

    zzdnc(zzdnb zzdnbVar, zzdag zzdagVar, zzdnh zzdnhVar) {
        this.zzhct = zzdnbVar;
        this.zzgty = zzdagVar;
        this.zzhcs = zzdnhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzcjg zzcjgVar) {
        zzcjg zzcjgVar2 = zzcjgVar;
        synchronized (this.zzhct) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyf)).booleanValue()) {
                zzcjgVar2.zzaiz().zza(this.zzhct.zzhcq);
            }
            this.zzgty.onSuccess(zzcjgVar2);
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyf)).booleanValue()) {
                this.zzhct.zzfoc.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdnf
                    private final zzdnc zzhcu;

                    {
                        this.zzhcu = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzhcu.zzhct.zzhcq.onAdLoaded();
                    }
                });
            }
            this.zzhct.zzhcq.onAdMetadataChanged();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzcjj zzcjjVar = (zzcjj) this.zzhct.zzhaj.zzasv();
        final zzva zzvaVarZza = zzcjjVar == null ? zzdpe.zza(th, (zzctd) null) : zzcjjVar.zzaev().zze(th);
        synchronized (this.zzhct) {
            if (zzcjjVar != null) {
                zzcjjVar.zzaew().zzk(zzvaVarZza);
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyf)).booleanValue()) {
                    this.zzhct.zzfoc.execute(new Runnable(this, zzvaVarZza) { // from class: com.google.android.gms.internal.ads.zzdne
                        private final zzva zzgte;
                        private final zzdnc zzhcu;

                        {
                            this.zzhcu = this;
                            this.zzgte = zzvaVarZza;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdnc zzdncVar = this.zzhcu;
                            zzdncVar.zzhct.zzhcq.zzk(this.zzgte);
                        }
                    });
                }
            } else {
                this.zzhct.zzhcq.zzk(zzvaVarZza);
                this.zzhct.zze(this.zzhcs).zzagl().zzaev().zzaji().zzake();
            }
            zzdox.zza(zzvaVarZza.errorCode, th, "RewardedAdLoader.onFailure");
            this.zzgty.zzaqv();
        }
    }
}
