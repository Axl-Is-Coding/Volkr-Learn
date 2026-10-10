package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdaj implements zzdyr<zzbqo> {
    private final /* synthetic */ zzdag zzgty;
    private final /* synthetic */ zzcda zzgtz;
    final /* synthetic */ zzdai zzgua;

    zzdaj(zzdai zzdaiVar, zzdag zzdagVar, zzcda zzcdaVar) {
        this.zzgua = zzdaiVar;
        this.zzgty = zzdagVar;
        this.zzgtz = zzcdaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzbqo zzbqoVar) {
        zzbqo zzbqoVar2 = zzbqoVar;
        synchronized (this.zzgua) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyi)).booleanValue()) {
                zzbqoVar2.zzaiz().zza(this.zzgua.zzgtw.zzaqx());
            }
            this.zzgty.onSuccess(zzbqoVar2);
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyi)).booleanValue()) {
                this.zzgua.zzgpt.zzadi().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdam
                    private final zzdaj zzgub;

                    {
                        this.zzgub = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgub.zzgua.zzgtw.zzaqz().onAdLoaded();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        final zzva zzvaVarZze = this.zzgtz.zzaev().zze(th);
        this.zzgtz.zzaew().zzk(zzvaVarZze);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyi)).booleanValue()) {
            this.zzgua.zzgpt.zzadi().execute(new Runnable(this, zzvaVarZze) { // from class: com.google.android.gms.internal.ads.zzdal
                private final zzva zzgte;
                private final zzdaj zzgub;

                {
                    this.zzgub = this;
                    this.zzgte = zzvaVarZze;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzdaj zzdajVar = this.zzgub;
                    zzdajVar.zzgua.zzgtw.zzara().zzk(this.zzgte);
                }
            });
        }
        zzdox.zza(zzvaVarZze.errorCode, th, "NativeAdLoader.onFailure");
        this.zzgty.zzaqv();
    }
}
