package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [AppOpenAd] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdkb<AppOpenAd> implements zzdyr<AppOpenAd> {
    private final /* synthetic */ zzdag zzgty;
    private final /* synthetic */ zzdkd zzham;
    final /* synthetic */ zzdjw zzhan;

    zzdkb(zzdjw zzdjwVar, zzdag zzdagVar, zzdkd zzdkdVar) {
        this.zzhan = zzdjwVar;
        this.zzgty = zzdagVar;
        this.zzham = zzdkdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Object obj) {
        zzbqo zzbqoVar = (zzbqo) obj;
        synchronized (this.zzhan) {
            zzdjw.zza(this.zzhan, (zzdzc) null);
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyg)).booleanValue()) {
                zzbqoVar.zzaiz().zza(this.zzhan.zzhai);
            }
            this.zzgty.onSuccess(zzbqoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzbnw zzbnwVar = (zzbnw) this.zzhan.zzhaj.zzasv();
        final zzva zzvaVarZza = zzbnwVar == null ? zzdpe.zza(th, (zzctd) null) : zzbnwVar.zzaev().zze(th);
        synchronized (this.zzhan) {
            zzdjw.zza(this.zzhan, (zzdzc) null);
            if (zzbnwVar != null) {
                zzbnwVar.zzaew().zzk(zzvaVarZza);
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyg)).booleanValue()) {
                    this.zzhan.zzfoc.execute(new Runnable(this, zzvaVarZza) { // from class: com.google.android.gms.internal.ads.zzdka
                        private final zzva zzgte;
                        private final zzdkb zzhal;

                        {
                            this.zzhal = this;
                            this.zzgte = zzvaVarZza;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdkb zzdkbVar = this.zzhal;
                            zzdkbVar.zzhan.zzhai.zzk(this.zzgte);
                        }
                    });
                }
            } else {
                this.zzhan.zzhai.zzk(zzvaVarZza);
                ((zzbnw) this.zzhan.zzb(this.zzham).zzaey()).zzaev().zzaji().zzake();
            }
            zzdox.zza(zzvaVarZza.errorCode, th, "AppOpenAdLoader.onFailure");
            this.zzgty.zzaqv();
        }
    }
}
